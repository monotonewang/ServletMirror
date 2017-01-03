package com.demo.servletpath.enhance2.annoation.bank;

import java.lang.reflect.Method;

/**
 * Created by 7 on 2017/1/3.
 */
public class Bank {


	// name1向name2转账money元---使用配置文件完成
	public void account1(String name1, String name2, int money) {

		if (money > GlobalFiled.maxMoney) {
			throw new RuntimeException("最大转账金额为:5000元");
		}

		System.out.println(name1 + "向" + name2 + "转账:" + money + "元");
	}

	//name1向name2转账--使用注解完成
	@BankInfo(maxMoney = 10000)
	public void account(String name1, String name2, int money) throws NoSuchMethodException {
		// 1.获取当前方法的Method对象。

		// 1.1 获取当前类的Class对象
		Class clazz = this.getClass();

		// 1.2 获取当前方法的Method对象.
		Method method = clazz.getDeclaredMethod("account", String.class,
				String.class, int.class);

		boolean flag = method.isAnnotationPresent(BankInfo.class); // 判断当前方法上是否有BankInfo这个注解.
		if (flag) {
			// 2.在Method类中有一个 getAnnotation(Class annotationClass)，可以获取一个注解对象.
			BankInfo bif = method.getAnnotation(BankInfo.class);

			// 3.通过注解对象来调用其属性.
			int maxMoney = bif.maxMoney();
			if (money > maxMoney) {
				throw new RuntimeException("最大转账金额=" + maxMoney + "元");
			}
		}
		System.out.println(name1 + "向" + name2 + "转账：" + money + "元");
	}
}
