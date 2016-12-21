package com.demo.servletpath.jdbc.dao;

import com.demo.servletpath.jdbc.bean.User;
import org.junit.Test;

import java.sql.Date;
import java.util.List;



public class DaoImpl {
	Dao dao=new Dao();

	@Test
	public void testUpdate() {
		String sql="insert into user(id,name,email,brith) "
				+ "values(?,?,?,?)";
		dao.update(sql, 2,"mi","xaoiom@173.com",new Date(new java.util.Date().getTime()));
	}

	@Test
	public void testGet() {
		String sql="select Id id,Name name,Password password,Email email,Brith brith from user where id= ?";
		User user=dao.get(User.class, sql, 1);
		System.out.println(user);
	}

	/**
	 * 查询方法，得到多个结果集
	 * @param clazz 类对象
	 * @param <T> javaBean
	 */
	@Test
	public <T> void testGetForList(Class<T> clazz){
		String sql="select FlowID flowID,Type type,IdCard idCard,ExamStudent examStudent,StudentName studentName,Location location,Gradle gradle from examstudent";
		List<T> students=dao.getForList(clazz, sql);
		System.out.println(students);
	}

	/**
	 * 获取单个记录
	 */
	@Test
	public void testGetForValue(){
		String sql="select email from user where id=?";
		String email=dao.getForValue(sql,1);
		System.out.println(email);
	}

}
