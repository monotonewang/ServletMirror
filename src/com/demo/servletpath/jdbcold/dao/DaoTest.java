package com.demo.servletpath.jdbcold.dao;

import com.demo.servletpath.jdbcold.bean.Student;
import com.demo.servletpath.jdbcold.bean.User;
import org.junit.Test;

import java.sql.Date;
import java.util.List;



public class DaoTest {
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
	
	@Test
	public void testGetForList(){
		String sql="select FlowID flowID,Type type,IdCard idCard,ExamStudent examStudent,StudentName studentName,Location location,Gradle gradle from examstudent";
		List<Student> students=dao.getForList(Student.class, sql);
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
