package com.demo.servletpath.jdbc.transaction;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by WangTest on 2016/12/11.
 */
public class DbcpTest {
    /**
     * 手动配置dbcp需要加载dbcp.jar pool.jar
     */
    @Test
    public void dbcpManual() {
        BasicDataSource bds = new BasicDataSource();
        //需要设置驱动，用户名 ，密码，
        bds.setDriverClassName("com.mysql.jdbc.Driver");
//        bds.setUrl("jdbc:mysql:///day16");
        bds.setUrl("jdbc:mysql://127.0.0.1:3306/day16?characterEncoding=utf8&useSSL=true");
        bds.setUsername("root");
        bds.setPassword("root");
        try {
            Connection connection = bds.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from dept");
            while (resultSet.next()) {
                System.out.println("rs" + resultSet.getInt("did") + "dname" + resultSet.getString("dname")
                        + "" + "sal=" + resultSet.getString("sal"));
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自动获取连接池
     */
    @Test
    public void dbcpAuto(){
        Properties properties=new Properties();
        properties.setProperty("driverClassName","com.mysql.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://127.0.0.1:3306/day16?characterEncoding=utf8&useSSL=true");
        properties.setProperty("username","root");
        properties.setProperty("password","root");

        try {
            //加载配置文件
            InputStream inputStream=new FileInputStream("");

            BasicDataSource bds=BasicDataSourceFactory.createDataSource(properties);
            Connection connection = bds.getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from dept");
            while (resultSet.next()) {
                System.out.println("rs" + resultSet.getInt("did") + "dname" + resultSet.getString("dname")
                        + "" + "sal=" + resultSet.getString("sal"));
            }
            resultSet.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
