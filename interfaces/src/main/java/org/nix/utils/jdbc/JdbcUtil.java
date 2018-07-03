package org.nix.utils.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class JdbcUtil {

   private static final String URL
           = "jdbc:mysql://127.0.0.1:3306/log?useUnicode=true&amp;characterEncoding=utf-8";

    private static final String ROOT = "root";

    private static final String PASSWORD = "bisha520";

    private static final String DIRVE_NAME = "com.mysql.jdbc.Driver";

    private static ComboPooledDataSource ds;

    static {
        try {
            ds = new ComboPooledDataSource();
            ds.setJdbcUrl(URL);
            ds.setUser(ROOT);
            ds.setPassword(PASSWORD);
            ds.setDriverClass(DIRVE_NAME);
            ds.setAcquireIncrement(5);
            ds.setInitialPoolSize(20);
            ds.setMinPoolSize(2);
            ds.setMaxPoolSize(50);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static ComboPooledDataSource getPool(){
        return ds;
    }
}
