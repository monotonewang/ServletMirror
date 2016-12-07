package com.demo.servletpath.jdbc.connector.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils1 {

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		// 2.获取连接
		Connection con = DriverManager.getConnection("jdbc:mysql:///day17",
				"root", "abc");

		return con;
	}
}
