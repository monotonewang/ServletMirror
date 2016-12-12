package com.demo.servletpath.jdbc.transaction.account.dao;

import com.demo.servletpath.jdbc.transaction.account.exception.AccountException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/12.
 */
public class AccountImpl implements AccountDao {

	/**
	 * trsnfer money in
	 * @param connection
	 * @param accountIn
	 * @param money
	 * @throws AccountException
	 */
	@Override
	public void accountIn(Connection connection, String accountIn, double money) throws AccountException {
		String sql="update emp set sal =sal+? where name=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1,money);
			preparedStatement.setString(2,accountIn);
			int row = preparedStatement.executeUpdate();
			if(row==0){
				throw new AccountException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * tranfer money out
	 * @param connection
	 * @param accountOut
	 * @param money
	 * @throws AccountException
	 */
	@Override
	public void accountOut(Connection connection, String accountOut, double money) throws AccountException {
		String sql="update emp set sal =sal-? where name=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1,money);
			preparedStatement.setString(2,accountOut);
			int row = preparedStatement.executeUpdate();
			if(row==0){
				throw new AccountException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void accountIn(String accountOut, double money) throws AccountException {

	}

	@Override
	public void accountOut(String accountOut, double money) throws AccountException {

	}
}
