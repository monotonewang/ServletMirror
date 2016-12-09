package com.demo.servletpath.jdbc.connection;

import com.demo.servletpath.jdbc.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCRUD {

	@Test
	public void testSelect() throws SQLException {
		Connection con = JdbcUtils.getConnectionByRes();
//		Connection con = getConnection1();
//		Connection con = getConnection2();
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

			System.out.println(id + "  " + username + "  " + password + "  " + email);
		}
		//6.释放资源
		rs.close();
		st.close();
		con.close();
	}

	@Test
	public  void AbsoluteTest1() throws SQLException {
		// 1.得到一个Connection
		Connection con = JdbcUtils.getConnectionByRes();

		// 2.得到一个执行sql语句Statement
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);

		// 3.执行sql，得到结果集
		ResultSet rs = st.executeQuery("select * from user");

		// 4.定位
		rs.absolute(3);

		// System.out.println(rs.getInt("id") + "  " +
		// rs.getString("username"));

		// rs.afterLast();
		//
		// while (rs.previous()) {
		// System.out.println(rs.getInt("id") + "  "
		// + rs.getString("username"));
		// }
		rs.updateString("password", "456");
		rs.updateRow();

		// 5.关闭
		rs.close();
		st.close();
		con.close();
	}

	// 添加操作
	@Test
	public void addTest() {
		// 定义sql
		String sql = "insert into user values(null,'张三','123','zs@163.com')";
		Connection con = JdbcUtils.getConnectionByRes();
		Statement st = null;
		ResultSet rs = null;
		try {
			// 3.获取操作sql语句对象Statement
			st = con.createStatement();

			// 4.执行sql
			int row = st.executeUpdate(sql);

			if (row != 0) {
				System.out.println("添加成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			JdbcUtils.release(rs, st, con);
		}
	}

	// update操作
	@Test
	public void updateTest() {
		// 将id=3的人的password修改为456
		String password = "456";
		String sql = "update user set password='" + password + "' where id=3";
		// 1.得到Connection
		Connection con = null;
		Statement st = null;
		try {
			con = JdbcUtils.getConnectionByRes();
			// 3.获取操作sql语句对象Statement
			st = con.createStatement();
			// 4.执行sql
			int row = st.executeUpdate(sql);
			if (row != 0) {
				System.out.println("修改成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.释放资源
			JdbcUtils.release(null, st, con);
		}

	}

	// delete测试
	@Test
	public void deleteTest() {
		// 将id=3的人删除
		String sql = "delete from user where id=2";
		// 1.得到Connection
		Connection con = null;
		Statement st = null;
		try {
			con = JdbcUtils.getConnectionByRes();

			// 3.获取操作sql语句对象Statement
			st = con.createStatement();

			// 4.执行sql
			int row = st.executeUpdate(sql);

			if (row != 0) {
				System.out.println("删除成功");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			JdbcUtils.release(null, st, con);
		}

	}

}
