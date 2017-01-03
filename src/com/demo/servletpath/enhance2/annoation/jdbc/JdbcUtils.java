package com.demo.servletpath.enhance2.annoation.jdbc;

import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

/**
 * Created by 7 on 2017/1/3.
 */
public class JdbcUtils {

	@Test
	public void getConnection() throws Exception {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql:///jdbctest";
		String username = "root";
		String password = "root";
		// 1.加载驱动
		Class.forName(driverClassName);
		// 2.获取连接
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("not null");
			return;
		}
	}


	@JdbcInfo(driverClassName = "com.mysql.jdbc.Driver", url = "jdbc:mysql:///jdbctest", username = "root", password = "root")
	public static Connection getConnectionByAnnotation(String[] args) throws Exception {

		System.out.println(Arrays.toString(args));
		// 得到当前方法上的注解JdbcInfo
		Method method = JdbcUtils.class
				.getDeclaredMethod("getConnectionByAnnotation", String[].class);
		JdbcInfo jif = method.getAnnotation(JdbcInfo.class);

		String driverClassName = jif.driverClassName();
		String url = jif.url();
		String username = jif.username();
		String password = jif.password();
		// 1.加载驱动
		Class.forName(driverClassName);
		// 2.获取连接
		Connection con = DriverManager.getConnection(url, username, password);

		return con;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getConnectionByAnnotation(new String[]{"abc"}));
	}

}
