package com.demo.servletpath.dbutils.utils;

import com.demo.servletpath.dbutils.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetHandlerTest {

	// 将结果封装到一个javaBean
	@Test
	public void fun1() throws SQLException {

		String sql = "select * from dept where id=?";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		Account a = runner.query(sql, new ResultSetHandler<Account>() {//ResultSetHandler上的泛型就是我们执行query方法后得到的结果.

			//重写handle方法，在这个方法中确定，怎样将结果集封装。
			public Account handle(ResultSet rs) throws SQLException {

				Account a = null;
				if (rs.next()) {
					a = new Account();
//					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					a.setMoney(rs.getDouble("money"));
				}

				return a;
			}
		}, 2);

		System.out.println(a);
	}
}
