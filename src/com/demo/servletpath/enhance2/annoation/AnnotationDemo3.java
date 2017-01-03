package com.demo.servletpath.enhance2.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by 7 on 2017/1/3.
 */
//注解中的属性值问题
@MyAnnoation3
public class AnnotationDemo3 {
	@MyAnnoation3
	public void show() {
	}
}

@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyAnnoation3 {
	//String st() default "abc";

	//int[] i();

	//String[] value();
	//int i();


	String value() default "hello";
}

class cost {
	//1380 fly
	//72 car
	//16 water
	//9  (metrio)+13(car)
	//30 fenghuan mon290
	//14 evening
	//16 monring
	//50 car
	//21 lunch
	//50 eat
	//66 eat
	//20 car
	//2 car
	//9 red
}