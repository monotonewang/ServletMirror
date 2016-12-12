package com.demo.servletpath.dbutils.utils;

import com.demo.servletpath.dbutils.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * transaction
 */
public class QueryRunnerTest {

	@Test
	// 使用无参数 的QueryRunner
	public void fun1() throws SQLException {
		String sql = "select * from dept where id>? and name=? ";
		QueryRunner runner = new QueryRunner(); // 事务手动控制

		Connection con = DataSourceUtils.getConnection();

		// con.setAutoCommit(false);

		List<Account> list = runner.query(con, sql,
				new BeanListHandler<Account>(Account.class),2,"张三");

		// con.rollback();
		System.out.println(list);
	}

	@Test
	// 使用有参数 的QueryRunner
	public void fun2() throws SQLException {
		String sql = "select * from dept where id=?";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource()); // 自动事务
		List<Account> list = runner.query(sql, new BeanListHandler<Account>(
				Account.class),2);
		System.out.println(list);
	}
}
