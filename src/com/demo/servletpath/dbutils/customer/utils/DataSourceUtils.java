package com.demo.servletpath.dbutils.customer.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/12.
 */
public class DataSourceUtils {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
//	static{
//		try {
//			cpds.setDriverClass("com.mysql.jdbc.Driver");
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//		cpds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/day16?characterEncoding=utf8&useSSL=true");
//		cpds.setUser("root");
//		cpds.setPassword("root");
//	}
	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}

	public static DataSource getDataSource() {
		return cpds;
	}
}
