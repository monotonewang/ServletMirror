package com.demo.servletpath.jdbc.transaction.account.dao;

import com.demo.servletpath.jdbc.transaction.account.exception.AccountException;

import java.sql.Connection;

/**
 * Created by 7 on 2016/12/12.
 */
public  interface AccountDao {
	public void accountIn(Connection connection, String accountIn, double money) throws AccountException;
	public void accountOut(Connection connection,String accountOut,double money) throws AccountException;
	public void accountIn(String accountOut,double money) throws AccountException;
	public void accountOut(String accountOut,double money) throws AccountException;
}
