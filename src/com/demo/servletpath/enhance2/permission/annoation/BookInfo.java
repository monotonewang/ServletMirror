package com.demo.servletpath.enhance2.permission.annoation;

import java.lang.annotation.*;

/**
 * Created by 7 on 2017/1/4.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface BookInfo {
	String value();//这就是权限名称
}
