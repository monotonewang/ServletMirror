package com.demo.servletpath.enhance.enumtest;

import org.junit.Test;

public class User {
	
	private int id;
	private String name;
	// 在很久很久之前
	private int role1;
	// 对象类型
	private Role2 role2;
	
	// 枚举
	private Role3 role3;
	
	@Test
	public void run(){
		User user = new User();
		user.id = 1;
		user.name = "美美";
		// user.role1 = Role1.BOSS;		// 可读性比较好，可以传入任意的类型。
		//user.role2 = Role2.BOSS;		// 可读性比较好，可以自己传入对象。
		user.role3 = Role3.BOSS;		// 枚举
	}
}


/**
 * 枚举
 * @author Administrator
 */
enum Role3{
	BOSS,HR,WORKER;
}

/**
 * 在很久之前
 * @author Administrator
 *
 */
class Role2{
	private Role2(){ }
	public static final Role2 BOSS = new Role2();
	public static final Role2 HR = new Role2();
	public static final Role2 WORKER = new Role2();
}

/**
 * 在很久很久之前
 * @author Administrator
 *
 */
class Role1{
	public static final int BOSS = 0;
	public static final int HR = 1;
	public static final int WORKER = 2;
}



