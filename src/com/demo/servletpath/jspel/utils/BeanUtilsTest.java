package com.demo.servletpath.jspel.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;


public class BeanUtilsTest {
	@Test
	public void testGetUser() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Object object = new Student();
		BeanUtils.setProperty(object, "setName", "test");
		System.out.println(object);
		Object val = BeanUtils.getProperty(object, "name");
		System.out.println(val);
	}

	@Test
	public void test() throws IllegalAccessException, InvocationTargetException {
		Student student = new Student();
		String sname = "abv";
		BeanUtils.setProperty(student, "name", sname);
		System.out.println(student.getName());
	}

}

class Student {
	String name;
	String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}