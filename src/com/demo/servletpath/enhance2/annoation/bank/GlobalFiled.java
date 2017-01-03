package com.demo.servletpath.enhance2.annoation.bank;

import java.util.ResourceBundle;

/**
 * Created by 7 on 2017/1/3.
 */
 class GlobalFiled {
	protected static int maxMoney = Integer.parseInt(ResourceBundle.getBundle("com/demo/servletpath/enhance2/annoation/bank/bank").getString("money"));

	/**
	 * print the maxMoney
	 */
//	@Test
//	public void tests() {
//		System.out.println(maxMoney);
//	}
}
