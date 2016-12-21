package com.demo.servletpath.dbutils.meta;


import com.demo.servletpath.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 描述 数据库 的元数据对象.
 */
public class DataBaseMetaDataTest {

	public static void main(String[] args) throws SQLException {
		ResultSet resultSet = null;
		Connection con = JdbcUtils.getConnectionByRes();
		//获取DataBaseMetaData
		DatabaseMetaData dmd = con.getMetaData();

		String driverName = dmd.getDriverName(); //获取驱动名称
		System.out.println(driverName);

		String userName = dmd.getUserName();//获取用户名
		System.out.println(userName);

		String url = dmd.getURL();//获取url
		System.out.println(url);

		String databaseProductName = dmd.getDatabaseProductName(); //获取数据库名称
		System.out.println(databaseProductName);

		String databaseProductVersion =
				dmd.getDatabaseProductVersion();//获取数据库版本.
		System.out.println(databaseProductVersion);

		//1. 得到数据库主要的版本号
		int version = dmd.getDatabaseMajorVersion();
		System.out.println(version);

		resultSet = dmd.getCatalogs();
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
		ResultSet rs = dmd.getPrimaryKeys(null, null, "dept");
		while (rs.next()) {
			System.out.println(rs.getObject(3));
		}

	}
}
