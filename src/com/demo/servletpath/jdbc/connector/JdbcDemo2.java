package com.demo.servletpath.jdbc.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//解决关于加载驱动问题
public class JdbcDemo2 {

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {

		// 1.注册驱动
		// DriverManager.registerDriver(new Driver()); //加载了两个驱动
		Class.forName("com.mysql.jdbc.Driver"); // 加载mysql驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");// 加载oracle驱动

		// String url="jdbc:mysql://localhost:3306/day17";
		String url = "jdbc:mysql:///day17";

		// 2.获取连接对象
		Connection con = DriverManager.getConnection(url, "root", "abc");

		// 3.通过连接对象获取操作sql语句Statement
		Statement st = con.createStatement();

		// 4.操作sql语句
		String sql = "select * from user";

		// 操作sql语句(select语句),会得到一个ResultSet结果集
		ResultSet rs = st.executeQuery(sql);

		// 5.遍历结果集
		// boolean flag = rs.next(); // 向下移动，返回值为true，代表有下一条记录.
		// int id = rs.getInt("id");
		// String username=rs.getString("username");
		// System.out.println(id);
		// System.out.println(username);

		while (rs.next()) {
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String email = rs.getString("email");

			System.out.println(id + "  " + username + "  " + password + "  "
					+ email);
		}

		// 6.释放资源
		rs.close();
		st.close();
		con.close();
	}
}
