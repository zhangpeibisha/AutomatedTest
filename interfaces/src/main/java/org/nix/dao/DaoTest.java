package org.nix.dao;

import org.nix.po.LogPo;
import org.nix.po.ParametersPo;

import java.sql.Date;
import java.sql.SQLException;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class DaoTest {

    public static void main(String[] args) {

        LogPo logPo =
                new LogPo("测试方法名","测试返回结果",10
                        ,new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()));

        ParametersPo parametersPo = new ParametersPo("参数名字","参数值");
        logPo.addParameter(parametersPo);

        LogDao dao = new LogDao();
        try {
            dao.insertCompleteLog(logPo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
