package com.demo.servletpath.jdbc.connector;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class JdbcDemo1 {

	public static void main(String[] args) throws SQLException {

		// 1.注册驱动
		DriverManager.registerDriver(new Driver());

		// 2.获取连接对象
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/jdbctest?characterEncoding=utf8&useSSL=true", "root", "root");

		// 3.通过连接对象获取操作sql语句Statement
		Statement st = con.createStatement();

		// 4.操作sql语句
		String sql = "select * from examstudent";

		// 操作sql语句(select语句),会得到一个ResultSet结果集
		ResultSet rs = st.executeQuery(sql);

		// 5.遍历结果集
		// boolean flag = rs.next(); // 向下移动，返回值为true，代表有下一条记录.
		// int id = rs.getInt("id");
		// String username=rs.getString("username");
		// System.out.println(id);
		// System.out.println(username);
		
		while(rs.next()){
			int id=rs.getInt("id");
			String username=rs.getString("username");
			String password=rs.getString("password");
			String email=rs.getString("email");
			
			System.out.println(id+"  "+username+"  "+password+"  "+email);
		}
		
		//6.释放资源
		rs.close();
		st.close();
		con.close();
	}
}
