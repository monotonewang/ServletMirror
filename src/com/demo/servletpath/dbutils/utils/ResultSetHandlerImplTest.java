package com.demo.servletpath.dbutils.utils;

import com.demo.servletpath.dbutils.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//介绍ResultSetHandler的九个实现类.
public class ResultSetHandlerImplTest {
	// 将结果封装到一个javaBean
	@Test
	public void fun0() throws SQLException {

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

	// ArrayHandler
	@Test
	public void fun1() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		Object[] obj = runner
				.query("select * from dept", new ArrayHandler());

		System.out.println(Arrays.toString(obj));
	}

	// ArrayListHandler
	@Test
	public void fun2() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		List<Object[]> objs = runner.query("select * from dept",
				new ArrayListHandler());

		for (Object[] obj : objs) {
			System.out.println(Arrays.toString(obj));
		}
	}

	// BeanHandler
	@Test
	public void fun3() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		Account obj = runner.query("select * from dept",
				new BeanHandler<Account>(Account.class));

		System.out.println(obj);
	}

	// BeanListHandler
	@Test
	public void fun4() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		List<Account> obj = runner.query("select * from dept",
				new BeanListHandler<Account>(Account.class));

		System.out.println(obj);
	}

	// ColumnListHandler
	@Test
	public void fun5() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		List<Object> obj = (List<Object>) runner.query("select * from dept",
				new ColumnListHandler("name"));

		System.out.println(obj);
	}

	// MapHandler
	@Test
	public void fun6() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		Map<String, Object> obj = runner.query("select * from dept",
				new MapHandler());

		System.out.println(obj);
	}

	// MapListHandler
	@Test
	public void fun7() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		List<Map<String, Object>> obj = runner.query("select * from dept",
				new MapListHandler());

		System.out.println(obj);
	}

	//KeyedHandler

	@Test
	public void fun8() throws SQLException {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		Map<Object, Map<String, Object>> obj = (Map<Object, Map<String, Object>>) runner.query("select * from dept",
				new KeyedHandler("name"));

		System.out.println(obj);
	}

	//ScalarHandler
	@Test
	public void fun9() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		long obj = (Long) runner.query("select count(*) from dept", new ScalarHandler());

		System.out.println(obj);
	}


}
