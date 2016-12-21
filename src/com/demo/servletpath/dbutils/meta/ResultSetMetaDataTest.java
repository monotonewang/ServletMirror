package com.demo.servletpath.dbutils.meta;

import com.demo.servletpath.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class ResultSetMetaDataTest {

	public static void main(String[] args) throws SQLException {

		Connection con = JdbcUtils.getConnectionByRes();
		ResultSet rs = con.createStatement().executeQuery(
				"select * from dept");

		// 得到结果集元数据
		ResultSetMetaData rsmd = rs.getMetaData();

		System.out.println(rsmd.getColumnCount());//获取结果集中列数量

		System.out.println(rsmd.getColumnName(2));//获取结果集中指定列的名称.

		System.out.println(rsmd.getColumnTypeName(2));//获取结果集中指定列的类型。

		System.out.println(rsmd.getColumnLabel(2));//得到列的别名
		int count = rsmd.getColumnCount();

		for (int i = 1; i <= count; i++) {

			System.out.print(rsmd.getColumnName(i) + "(" + rsmd.getColumnTypeName(i) + ")" + "\t");
		}
		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= count; i++) {
				System.out.print(rs.getObject(i) + "\t\t");
			}
			System.out.println();
		}
	}
}
