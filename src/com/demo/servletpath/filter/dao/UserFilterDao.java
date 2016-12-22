package com.demo.servletpath.filter.dao;

import com.demo.servletpath.filter.domain.UserFilter;
import com.demo.servletpath.filter.utils.DataSourceUtils;
import com.demo.servletpath.filter.utils.Md5Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/22.
 */
public class UserFilterDao {

	public UserFilter findUser(String username, String password) throws SQLException {
		String sql = "select * from User where username=? and password=?";
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		UserFilter user = queryRunner.query(sql, new BeanHandler<>(UserFilter.class), username, Md5Utils.md5(password));
		return user;
	}
}
