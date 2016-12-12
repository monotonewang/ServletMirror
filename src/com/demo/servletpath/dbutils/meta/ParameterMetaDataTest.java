package com.demo.servletpath.dbutils.meta;

import com.demo.servletpath.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ParameterMetaDataTest {

	public static void main(String[] args) throws SQLException {
		Connection con= JdbcUtils.getConnectionByRes();

		String sql = "select * from dept where did=? and dname=?";
		PreparedStatement pst = con.prepareStatement(sql);

		// 获取一个ParameterMetaData
		ParameterMetaData pmd = pst.getParameterMetaData();

		int count = pmd.getParameterCount(); // 获取参数 个数
		System.out.println(count);

		String type1 = pmd.getParameterTypeName(1);
		System.out.println(type1);
	}
}
