package com.demo.servletpath.jdbc.lob;

import com.demo.servletpath.jdbc.utils.JdbcUtils;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyBlobTest {

	// 添加
	@Test
	public void save() throws SQLException, IOException {
		String sql = "insert into myblob values(null,?)";

		// 1.获取Connection
		Connection con = JdbcUtils.getConnectionByRes();
		// 2.获取PreparedStatement
		PreparedStatement pst = con.prepareStatement(sql);
		// 3.插入值
		File file = new File("D:\\java1110\\day17-jdbc\\视频\\3.jdbc快速入门.avi");
		FileInputStream fis = new FileInputStream(file);
		pst.setBinaryStream(1, fis, (int) (file.length()));
		int row = pst.executeUpdate();

		if (row != 0) {
			System.out.println("插入成功");
		}

		// 4.释放资源
		fis.close();
		pst.close();
		con.close();

	}

	// 获取
	@Test
	public void get() throws SQLException, IOException {
		String sql = "select * from myblob where id=?";

		// 1.获取Connection
		Connection con = JdbcUtils.getConnectionByRes();
		// 2.获取PreparedStatement
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 1);
		// 3.得到结果集
		ResultSet rs = pst.executeQuery();

		// 4.遍历结果集
		if (rs.next()) {
			// System.out.println(rs.getInt("id"));

			InputStream is = rs.getBinaryStream("content");// 得到的这个输入流它的源可以理解成就是数据库中的大二进制信息

			FileOutputStream fos = new FileOutputStream("d:/a.avi");

			int len = -1;
			byte[] b = new byte[1024 * 100];

			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
				fos.flush();
			}
			fos.close();
			is.close();

		}

		// 5.关闭
		rs.close();
		pst.close();
		con.close();
	}
}
