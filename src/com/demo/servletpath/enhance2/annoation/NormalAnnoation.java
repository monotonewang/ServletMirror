package com.demo.servletpath.enhance2.annoation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 7 on 2017/1/3.
 */
@SuppressWarnings("all") //java本身提供的3种注解方式。
public class NormalAnnoation implements A {

	@Override
	public void show() {

	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Deprecated
	public void print(){


	}

	public static void main(String[] args) {
		Date date = new Date();

		System.out.println(date.toLocaleString());

		int i = 10;

		List list = new ArrayList();
	}

}

interface A {
	void show();
}