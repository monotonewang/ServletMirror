package com.demo.servletpath.enhance2.excel.service;

import com.demo.servletpath.enhance2.excel.bean.User;
import com.demo.servletpath.enhance2.excel.dao.UserDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 7 on 2016/12/30.
 */
public class UserService {
	UserDao userDao=new UserDao();

	public List<User> findAll() throws SQLException {
		List<User> users = userDao.findAll();
		return users;
	}
}
