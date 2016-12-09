package com.demo.servletpath.jdbc.utils;

import java.sql.*;
import java.util.ResourceBundle;

//使用配置文件

public class JdbcUtils {

	private static final  String packageName="com/demo/servletpath/jdbc/pro/jdbc";
	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;

	static {
		DRIVERCLASS=ResourceBundle.getBundle(packageName).getString("driverclass");
		URL = ResourceBundle.getBundle(packageName).getString("url");
		USERNAME = ResourceBundle.getBundle(packageName).getString("username");
		PASSWORD = ResourceBundle.getBundle(packageName).getString("password");
	}
	static {
		try {
			// 将加载驱动操作，放置在静态代码块中.这样就保证了只加载一次.
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * @throws SQLException
	 */
	public static Connection getConnectionByRes() {
		// 2.获取连接
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null){
			System.out.print("not null");
		}
		return con;
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
			e1.printStackTrace();
		}
		try {
			if (stat != null) {
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
