package com.demo.servletpath.jdbcold.dao;

import com.demo.servletpath.jdbcold.JdbcTools;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Dao {
	/**
	 * update,delete,insert
	 * @param sql
	 * @param args
	 */
	public void update(String sql,Object... args){
		Connection con =null;
		PreparedStatement ps=null;
		try {
			con= JdbcTools.getConnection();
			ps=con.prepareStatement(sql);
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcTools.release(null, ps, con);
		}
	}

	/**
	 * 查询一条结果
	 * @param clazz
	 * @param sql
	 * @param args
	 * @param <T>
	 * @return
	 */
	public <T> T get(Class<T> clazz,String sql,Object ...args){
		T entity=null;
		Connection  con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);

			//去查询sql数据
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			rs=ps.executeQuery();
			if(rs.next()){
				//准备一个map对象
				HashMap<String,Object> map=new HashMap<String,Object>();
				ResultSetMetaData rsm=ps.getMetaData();
				int count=rsm.getColumnCount();
				for(int i=0;i<count;i++){
					String column=rsm.getColumnLabel(i+1);
					Object columnValue=rs.getObject(i+1);
					map.put(column, columnValue);
				}
				entity=clazz.newInstance();
				for(Map.Entry<String, Object> entry:map.entrySet()){
					String proName=entry.getKey();
					Object value=entry.getValue();
//					ReflectionUtils.setFieldValue(entity, proName,value);
					BeanUtils.setProperty(entity, proName, value);
				}
			}
			return entity;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcTools.release(null, ps, con);
		}
		
		return null;
	}
	
	public <T> List<T> getForList(Class<T> clazz,String sql,Object ...args){
		List <T> list =new ArrayList<>();
	
		Connection  con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//1.获取连接
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);

			//去查询sql数据
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			//2.得到结果集。处理结果集。得到Map的list.其中一个Map的队形就是一条记录。map的key为resultSet中的别名。Map的values为列的值。
			rs=ps.executeQuery();
			List<Map<String, Object>> values = handlerResultSetToMapList(rs);
			T bean=null;
			//3.把map的list转为clazz对应的list.
			
			list=transfterMapListToBeanList(clazz, list, values);
	
			return list;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcTools.release(null, ps, con);
		}
		
		return null;
	}

	/**
	 * 把一个Map类型
	 * @param clazz
	 * @param list
	 * @param values
	 * @param <T>
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private <T> List<T> transfterMapListToBeanList(Class<T> clazz, List<T> list, List<Map<String, Object>> values)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<T> result=new ArrayList<>();
		T bean;
		if(values.size()>0){
			for(Map<String, Object> m:values){
				bean=clazz.newInstance();
				for(Map.Entry<String, Object> entry:m.entrySet()){
					String proName=entry.getKey();
					Object value=entry.getValue();
					BeanUtils.setProperty(bean, proName, value);
				}
				result.add(bean);
			}
		}
		return result;
	}

	/**
	 * 处理结果集，得到Map的List,其中一个Map对象对应一条记录。
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<Map<String, Object>> handlerResultSetToMapList(ResultSet rs) throws SQLException {
		//5获取一个map
		List<Map<String,Object>> values=new ArrayList<>();
		List<String> cloumnLabels =getColumnLabels(rs);

		Map<String,Object> map=null;
		//7结果集，使用while循环
		while(rs.next()){
			////准备一个map对象
			map=new HashMap<String,Object>();
			
			for(String cloumnLabel:cloumnLabels ){
				Object columnValue=rs.getObject(cloumnLabel);
				map.put(cloumnLabel, columnValue);
			}
			values.add( map);
		}
		return values;
	}

	/**
	 * 获取结果集的 ColumnLabel 对应的 List
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private List<String> getColumnLabels(ResultSet rs) throws SQLException {
		List<String> labels = new ArrayList<>();

		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			labels.add(rsmd.getColumnLabel(i + 1));
		}

		return labels;
	}
	public <E> E getForValue(String sql,Object ...args){
		//1.获取结果集，结果只有一行或者一列

		Connection  con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//1.获取连接
			con=JdbcTools.getConnection();
			ps=con.prepareStatement(sql);

			//去查询sql数据
			for(int i=0;i<args.length;i++){
				ps.setObject(i+1, args[i]);
			}
			//2.得到结果集。处理结果集。得到Map的list.其中一个Map的队形就是一条记录。map的key为resultSet中的别名。Map的values为列的值。
			rs=ps.executeQuery();
			if(rs.next()){
				return (E)rs.getObject((int)args[0]);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			JdbcTools.release(null, ps, con);
		
		}
		//2.取得结果集
		
		return null;
	}
}
