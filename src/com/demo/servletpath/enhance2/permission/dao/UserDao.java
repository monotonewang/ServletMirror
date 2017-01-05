package com.demo.servletpath.enhance2.permission.dao;

import com.demo.servletpath.dbutils.utils.DataSourceUtils;
import com.demo.servletpath.enhance2.permission.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by 7 on 2017/1/4.
 */
public class UserDao {
	public User findUser(String username, String password) throws SQLException {
		String sql="select * from pusers where username= ? and password= ?";
		QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql,new BeanHandler<>(User.class),username,password);
	}
}
