package com.demo.servletpath.enhance.autoboxing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动装箱和拆箱
 * @author Administrator
 *
 */
public class Demo1 {
	
	@Test
	public void run1(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		// 自动装箱
		Integer i = 1;
		// 自动拆箱
		int j = i;
	}
	
	/*
	// JDK1.4版本
	public void run2(){
		List list = new ArrayList();
		list.add(new Integer(1));
		
		// 自动装箱
		Integer i = new Integer(1);
		// 自动拆箱
		int j = i.intValue();
	}*/
	
	
	// 向下兼容
	@Test
	public void run3(){
		doXXX(1);
	}
	
	public void doXXX(Integer x){
		System.out.println("integer...");
	}
	
	public void doXXX(double x){
		System.out.println("double...");
	}
	
	@Test
	public void run4(){
		Integer n1 = 100;
		Integer n2 = 100;
		Integer n3 = new Integer(100);
		Integer n4 = new Integer(100);
		Integer n5 = 128;
		Integer n6 = 128;
		
		System.out.println(n1 == n2);		// true
		System.out.println(n3 == n4);		// false
		System.out.println(n5 == n6);		// false
	}
	
}











