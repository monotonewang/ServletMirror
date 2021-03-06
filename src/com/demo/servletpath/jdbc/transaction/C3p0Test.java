package com.demo.servletpath.jdbc.transaction;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WangTest on 2016/12/11.
 */
public class C3p0Test {
    @Test
    public void testManual() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/day16?characterEncoding=utf8&useSSL=true");
            cpds.setUser("root");
            cpds.setPassword("root");
            try {
                Connection connection = cpds.getConnection();
                ResultSet resultSet = connection.createStatement().executeQuery("select id,name,money from dept");
                while (resultSet.next()) {
                    System.out.println("rs" + resultSet.getInt("id") + "name" + resultSet.getString("name")
                            + "" + "money=" + resultSet.getString("money"));
                }
                resultSet.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAuto() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = cpds.getConnection();
            resultSet = connection.createStatement().executeQuery("select id,name from dept");
            while (resultSet.next()) {
                System.out.println("rs=" + resultSet.getInt("id") + "dname=" + resultSet.getString("name")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
