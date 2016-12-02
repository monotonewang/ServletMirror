package com.demo.servletpath.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcTools {
    public static Connection getConnection() throws Exception {
        //获取字符串
        Properties pro = new Properties();
        InputStream in = JdbcTools.class.getClassLoader().getResourceAsStream("/src/jdbc.properties");
        String driver;
        String jdbcUrl;
        Connection connection;
        if (in != null) {
            pro.load(in);
            driver = pro.getProperty("driver");
            jdbcUrl = pro.getProperty("jdbcUrl");
            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
        } else {
            driver = "com.mysql.jdbc.Driver";
            jdbcUrl = "jdbc:mysql://127.0.0.1:3306/jdbctest?characterEncoding=utf8&useSSL=true";
        }
        //加载驱动
        Class.forName(driver);
        //调用DriverManager
        if (in != null) {
            connection = DriverManager.getConnection(jdbcUrl, pro);
        } else {
            connection = DriverManager.getConnection(jdbcUrl, "root", "root");
        }
        //获取数据库连接
        System.out.println(connection);
        return connection;
    }

    /**
     * * 关闭数据库资源
     *
     * @param connection
     * @param stat
     */
    public static void release(ResultSet resultSet, Statement stat, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            if (stat != null) {
                stat.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

