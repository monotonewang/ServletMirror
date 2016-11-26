package com.demo.servletpath.enhance.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {
	
	@org.junit.BeforeClass
	public static void beforeClass(){
		System.out.println("BeforeClass...");
	}
	
	@Before
	public void before(){
		System.out.println("before...");
	}
	
	@Test
	public void eat(){
		System.out.println("eat...");
	}
	
	@Test
	public void run(){
		System.out.println("run...");
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
}
