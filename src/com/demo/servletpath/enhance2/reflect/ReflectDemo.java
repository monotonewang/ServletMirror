package com.demo.servletpath.enhance2.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by 7 on 2017/1/3.
 */
public class ReflectDemo {

	public static void main(String[] args) {
		System.out.println(args[0]);
	}

	@Test
	public void fun1() throws Exception {
		Method mainMethod = this.getClass().getDeclaredMethod("main",
				String[].class);

		mainMethod.invoke(null, new Object[]{(new String[]{"abc", "def"})});
	}
}
