package com.demo.servletpath.jdbc.connection;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by 7 on 2016/12/9.
 */
public class JdbcConnection {

	 static  Connection getConnection1() throws SQLException {
		// 1.注册驱动
		DriverManager.registerDriver(new Driver());

		// 2.获取连接对象
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/day17?characterEncoding=utf8&useSSL=true", "root", "root");
	}
	  static Connection getConnection2() throws ClassNotFoundException, SQLException {
		// 1.注册驱动
		// DriverManager.registerDriver(new Driver()); //加载了两个驱动
		Class.forName("com.mysql.jdbc.Driver"); // 加载mysql驱动
//		Class.forName("oracle.jdbc.driver.OracleDriver");// 加载oracle驱动

		// String url="jdbc:mysql://localhost:3306/day17";
		String url = "jdbc:mysql:///day17?characterEncoding=utf8&useSSL=true";

		// 2.获取连接对象
		return DriverManager.getConnection(url, "root", "root");
	}

	/**
	 * 得到连接的方法
	 *
	 * @return
	 * @throws Exception
	 */
	static Connection getConnection() throws Exception {
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;

		Properties pro = new Properties();
		InputStream in = JdbcConnection.class.getClass().getClassLoader().getResourceAsStream("com/demo/servletpath/jdbc/pro/jdbc.properties");
		pro.load(in);
//		driverClass=pro.getProperty("driver");
		jdbcUrl = pro.getProperty("jdbcUrl");
		user = pro.getProperty("user");
		password = pro.getProperty("password");

//		Driver driver=(Driver)Class.forName(driverClass).newInstance();
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);
//		DriverManager.deregisterDriver(driver);
		Connection con = DriverManager.getConnection(jdbcUrl, info);
//		 driver.connect(jdbcUrl, info);
		return con;
	}

	/**
	 * ResourceBundle
	 */
	@Test
	public void getResByResourBundle(){
		ResourceBundle resourceBundle=ResourceBundle.getBundle("com/demo/servletpath/jdbc/pro/jdbc");
		String driver = resourceBundle.getString("driver");
		System.out.print(driver);
	}
}