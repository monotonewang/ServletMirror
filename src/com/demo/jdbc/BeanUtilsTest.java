package com.demo.jdbc;

import com.demo.jdbc.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;



public class BeanUtilsTest {
	@Test
	public void testGetUser() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Object object=new User();
		
		BeanUtils.setProperty(object, "name", "21212");
		System.out.println(object);
		Object val=BeanUtils.getProperty(object, "name3");
		System.out.println(val);
	}
	@Test
	public void test() throws IllegalAccessException, InvocationTargetException {
		Object object=new User();
		
		BeanUtils.setProperty(object, "name", "21212");
		System.out.println(object);
	}

}
