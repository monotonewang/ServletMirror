package com.demo.servletpath.enhance2.permission.service;

import com.demo.servletpath.enhance2.permission.dao.UserDao;
import com.demo.servletpath.enhance2.permission.domain.User;

import java.sql.SQLException;

/**
 * Created by 7 on 2017/1/4.
 */
public class UserService {

	public User login(String username, String password) throws SQLException {

		return new UserDao().findUser(username,password);
	}
}
