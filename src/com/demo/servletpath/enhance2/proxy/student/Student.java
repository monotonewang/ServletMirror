package com.demo.servletpath.enhance2.proxy.student;

/**
 * Created by 7 on 2017/1/4.
 */
public class Student implements Person {
	@Override
	public String say(String msg) {
		return "hello" + msg;
	}
}
