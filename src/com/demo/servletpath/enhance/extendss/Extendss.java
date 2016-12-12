package com.demo.servletpath.enhance.extendss;

/**
 * Created by 7 on 2016/12/12.
 */
//使用继承增强
public class Extendss {
	public static void main(String[] args) {
		Person1 p=new Student1();

		p.eat();
	}
}

class Person1{

	public void eat(){
		System.out.println("吃两个馒头");
	}
}

class Student1 extends Person1{

	@Override
	public void eat(){
		super.eat();
		System.out.println("加两个鸡腿");
	}
}


