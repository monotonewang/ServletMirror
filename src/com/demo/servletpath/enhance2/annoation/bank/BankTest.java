package com.demo.servletpath.enhance2.annoation.bank;

/**
 * Created by 7 on 2017/1/3.
 */
public class BankTest {
	public static void main(String args[]){
		Bank bank=new Bank();
		try {
			bank.account("a","b",777777);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}


//		bank.account1("a","b",200);

	}
}
