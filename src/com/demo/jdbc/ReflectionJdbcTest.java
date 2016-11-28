package com.demo.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

public class ReflectionJdbcTest {

	/**
	 * *反射多元化对象。
	 * @param clazz
	 * @param sql
	 * @param args
	 * @param <T>
	 * @return
	 */
	@Test
	public <T> T test(Class<T> clazz,String sql,Object...args) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection=JdbcTools.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			ResultSetMetaData rsmd=resultSet.getMetaData();
			if(resultSet.next()){
				for(int i=0;i<args.length;i++){
					HashMap<String,Object> map=new HashMap<String,Object>();
					String column=rsmd.getColumnLabel(i);
					map.put(column, resultSet.getObject(i));
					System.out.println(map);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
