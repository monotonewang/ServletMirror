package com.demo.servletpath.jdbc.transaction.account.service;

import com.demo.servletpath.jdbc.transaction.account.dao.AccountImpl;
import com.demo.servletpath.jdbc.transaction.account.exception.AccountException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/12.
 */
public class AccountService {

	/**
	 * start tranfer money
	 * @param accountIn
	 * @param accountout
	 * @param money
	 * @throws AccountException
	 */
	public void account(String accountIn,String accountout,double money) throws AccountException, PropertyVetoException {
		AccountImpl accountDao=new AccountImpl();
		ComboPooledDataSource comboPooledDataSoure=new ComboPooledDataSource();
		//manual set connection
		comboPooledDataSoure.setDriverClass("com.mysql.jdbc.Driver");
		comboPooledDataSoure.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/day16?characterEncoding=utf8&useSSL=true");
		comboPooledDataSoure.setUser("root");
		comboPooledDataSoure.setPassword("root");

		Connection connection=null;
		try {
			 connection= comboPooledDataSoure.getConnection();
			//close autoCommit,start transaction
			connection.setAutoCommit(false);
			//transfer in
			accountDao.accountIn(connection,accountIn,money);
			//transfer out
			accountDao.accountOut(connection,accountout,money);
		} catch (SQLException e) {
			e.printStackTrace();
			//get problem ,need rollback
			if(connection!=null){
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				connection.commit();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
