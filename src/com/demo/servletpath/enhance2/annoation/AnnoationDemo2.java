package com.demo.servletpath.enhance2.annoation;

/**
 * Created by 7 on 2017/1/3.
 */
//注解中能放那些参数，
public class AnnoationDemo2 {

}

@interface MyAnnotation1 {

}

@interface MyAnnotation {
	//基本类型
	int show();

	float f();

	char c();

	boolean b();
	//字符串类型
	String s();
	//Class 类型
	Class cl();
	//枚举类型
	MyEnum m();
	//注解类型
	MyAnnotation1 my1();

	//以上类型的一维数组
	Class[] cls();

	String[] sts();
}

enum MyEnum {
	A, B, C
}