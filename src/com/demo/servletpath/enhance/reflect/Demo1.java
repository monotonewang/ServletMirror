package com.demo.servletpath.enhance.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 了解反射
 * @author Administrator
 *
 */
public class Demo1 {
	
	@Test
	public void run() throws Exception{
		// 三种方式获取class对象
		// 类名
		Class clazz1 = Person.class;
		// 通过实例
		Class clazz2 = new Person().getClass();
		// Class.forName
		Class clazz3 = Class.forName("com.javaweb.enhance.reflect.Person");
	}
	
	/**
	 * 获取构造的对象
	 * @throws Exception 
	 */
	@Test
	public void run2() throws Exception{
		// 获取Person的Class对象
		Class clazz = Class.forName("com.javaweb.enhance.reflect.Person");
		// clazz.getConstructors();		// 获取所有的构造方法
		// 创建实例
		// Person p = (Person) clazz.newInstance();	// 创建实例，相对于调用无参数的构造方法
		// 获取有参数的构造器
		Constructor c = clazz.getConstructor(int.class,String.class);
		Person p2 = (Person) c.newInstance(1,"美美");
		System.out.println(p2.getName());
	}
	
	/**
	 * 获取属性的对象
	 * @throws Exception 
	 */
	@Test
	public void run3() throws Exception{
		// 获取Person的Class对象
		Class clazz = Class.forName("com.javaweb.enhance.reflect.Person");
		// 声明实例
		Person p = (Person) clazz.newInstance();
		// 获取属性
		// clazz.getField("name");		// 获取是公有的name的属性
		
		Field name = clazz.getDeclaredField("name"); // 可以获取公有和私有都能获取
		name.setAccessible(true);		//	设置操作属性 	
		name.set(p, "郭美美");			// p.name = "郭美美";
		
		System.out.println(name.get(p));
	}
	
	/**
	 * 获取方法
	 * @throws Exception
	 */
	@Test
	public void run4() throws Exception{
		// 获取Person的Class对象
		Class clazz = Class.forName("com.javaweb.enhance.reflect.Person");
		// 声明实例
		Person p = (Person) clazz.newInstance();
		Method m = clazz.getDeclaredMethod("setName", String.class);
		m.setAccessible(true);
		m.invoke(p, "凤姐");		// p.setName = "凤姐";
		
		System.out.println(p.getName());
	}

}






