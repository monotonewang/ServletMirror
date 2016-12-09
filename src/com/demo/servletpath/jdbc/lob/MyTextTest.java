package com.demo.servletpath.jdbc.lob;

import com.demo.servletpath.jdbc.utils.JdbcUtils;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTextTest {

	// 存储
	@Test
	public void save() throws SQLException, FileNotFoundException {
		String sql = "insert into mytext values(null,?)";

		// 1.获取Connection
		Connection con = JdbcUtils.getConnectionByRes();
		// 2.获取PreparedStatement
		PreparedStatement pst = con.prepareStatement(sql);
		// 3.插入值
		File file = new File("D:\\java1110\\workspace\\day17_3\\a.txt");
		FileReader fr = new FileReader(file);
		pst.setCharacterStream(1, fr, (int) (file.length()));

		pst.executeUpdate();

		// 4.释放资源
		pst.close();
		con.close();
	}

	// 获取
	@Test
	public void get() throws SQLException, IOException {
		String sql = "select * from mytext where id=?";

		// 1.获取Connection
		Connection con = JdbcUtils.getConnectionByRes();
		// 2.获取PreparedStatement
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 1);
		// 3.得到结果集
		ResultSet rs = pst.executeQuery();

		// 4.遍历结果集
		if (rs.next()) {
			Reader r = rs.getCharacterStream("content");

			FileWriter fw = new FileWriter("d:/笔记.txt");

			int len = -1;
			char[] ch = new char[1024 * 100];

			while ((len = r.read(ch)) != -1) {
				fw.write(ch, 0, len);
				fw.flush();
			}
			fw.close();
			r.close();

		}

		pst.close();
		con.close();
	}
}
