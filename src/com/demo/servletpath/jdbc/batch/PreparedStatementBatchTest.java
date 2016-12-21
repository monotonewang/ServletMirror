package com.demo.servletpath.jdbc.batch;

import com.demo.servletpath.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementBatchTest {

	public static void main(String[] args) throws SQLException {
		// 向user表中插入1000条数据

		String sql = "insert into user values(?,?,?,?)";

		Connection con = JdbcUtils.getConnectionByRes();

		PreparedStatement pst = con.prepareStatement(sql);

		// 批处理
		long l=System.currentTimeMillis();
		for (int i = 1; i <= 100000; i++) {
			pst.setString(1, null);
			pst.setString(2, "name"+i+"");
			pst.setString(3, "password" + i);
			pst.setString(4, "email" + i);
			pst.addBatch();
			if(i%1000==0){
				pst.executeBatch();
				pst.clearBatch(); //清空缓存。
			}
		}
		//执行批处理
		pst.executeBatch();
		pst.close();
		con.close();
		System.out.println(System.currentTimeMillis()-l);
	}
}
