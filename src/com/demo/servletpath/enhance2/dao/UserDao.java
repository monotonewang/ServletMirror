package com.demo.servletpath.enhance2.dao;

import com.demo.servletpath.dbutils.customer.utils.DataSourceUtils;
import com.demo.servletpath.enhance2.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 7 on 2016/12/30.
 */
public class UserDao {
	/**
	 * 查询出来所有的User
	 * @return
	 * @throws SQLException
	 */
	public List<User> findAll() throws SQLException {
		String sql = "select * from user";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		List<User> users = queryRunner.query(sql, new BeanListHandler<>(User.class));
		return users;
	}
}
