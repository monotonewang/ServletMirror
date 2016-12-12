package com.demo.servletpath.dbutils.utils;

import com.demo.servletpath.dbutils.domain.Account;
import com.demo.servletpath.jdbc.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	// 查询
	@Test
	public void selectTest() throws SQLException {

		String sql = "select * from dept";

		QueryRunner runner = new QueryRunner();
		Connection con = JdbcUtils.getConnectionByRes();
		List<Account> as = runner.query(con, sql,
				new ResultSetHandler<List<Account>>() {

					public List<Account> handle(ResultSet rs)
							throws SQLException {
						List<Account> as = new ArrayList<Account>();
						while (rs.next()) {
							Account a = new Account();
							a.setId(rs.getInt("id"));
							a.setName(rs.getString("name"));
							a.setMoney(rs.getDouble("money"));

							as.add(a);
						}

						return as;
					}

				});

		for (Account a : as) {
			System.out.println(a);
		}
		DbUtils.close(con);
	}

	// 添加
	@Test
	public void addTest() throws SQLException {
		String sql = "insert into dept values(?,?,?)";
		QueryRunner runner = new QueryRunner();

		int row = runner.update(JdbcUtils.getConnectionByRes(), sql, 8,"张三", 1000d);

		System.out.println(row);
	}
}
