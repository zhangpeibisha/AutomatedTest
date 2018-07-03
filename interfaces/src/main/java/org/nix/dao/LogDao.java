package org.nix.dao;

import com.mysql.jdbc.Statement;
import org.nix.po.LogPo;
import org.nix.po.ParametersPo;
import org.nix.utils.jdbc.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class LogDao {
    /**
     * 向数据库中插入一条日志记录
     * @param logPo 日志记录
     * @return 日志记录的自增id,如果失败返回-1
     * @throws SQLException
     */
    private int insertLog(LogPo logPo) throws SQLException {
        String insertLogSQL =  "INSERT INTO log(log_method,log_result,log_start_time,log_end_time,log_use_time)" +
                " VALUES(?,?,?,?,?)";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertLogSQL,Statement.RETURN_GENERATED_KEYS);
        try {
            statement.setString(1,logPo.getMethodName());
            String result = logPo.getResult();
            if (result == null){
                statement.setString(2,"null");
            }else {
                statement.setString(2,result);
            }
            statement.setDate(3,logPo.getStartTime());
            statement.setDate(4,logPo.getEndTime());
            statement.setLong(5,logPo.getUseTime());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            return getGeneratedKeys(resultSet);
        }finally {
            connection.close();
            if (statement!=null){
                statement.close();
            }
        }
    }

    /**
     * 插入一条日志的方法入参参数
     * @param parametersPo 入参参数
     * @return 参数id
     * @throws SQLException
     */
    private int insertParameter(ParametersPo parametersPo) throws SQLException {
        String sql = "INSERT INTO parameter(parameter_name,parameter_value) VALUES(?,?)";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        try {
            statement.setString(1,parametersPo.getParameterName());
            statement.setObject(2,parametersPo.getValue());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            return getGeneratedKeys(resultSet);
        }finally {
            connection.close();
            if (statement!=null){
                statement.close();
            }
        }
    }

    /**
     * 在日志和参数的关联表中插入数据
     * @param logId 日志id
     * @param parameterId 参数id
     */
    private int insertLogAndParameters(int logId,int parameterId) throws SQLException {
        String sql = "INSERT INTO log_parameter(log_id,parameter_id) VALUES(?,?)";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        try {
            statement.setInt(1,logId);
            statement.setObject(2,parameterId);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            return getGeneratedKeys(resultSet);
        }finally {
            connection.close();
            if (statement!=null){
                statement.close();
            }
        }
    }

    /**
     * 插入日志记录
     * @param logPo
     * @return
     * @throws SQLException
     */
    public int insertCompleteLog(LogPo logPo) throws SQLException {
       int logKey = insertLog(logPo);
       if (logKey == -1){
           return -1;
       }
        List<ParametersPo> parametersPos = logPo.getParametersPos();
        if (parametersPos!=null){
            for (ParametersPo parametersPo : parametersPos) {
                int paraKey = insertParameter(parametersPo);
                if (paraKey==-1){
                    return -1;
                }
                int resultKey = insertLogAndParameters(logKey,paraKey);
                if (resultKey==-1){
                    return -1;
                }
            }
        }
        return logKey;
    }

    /**
     * 返回自增主键
     * @param resultSet 查询结果
     * @return 自增主键如果没有返回-1
     * @throws SQLException
     */
    private int getGeneratedKeys(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }

}
