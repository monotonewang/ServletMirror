package com.demo.servletpath.filter.autologin.service;

import com.demo.servletpath.filter.autologin.dao.UserFilterDao;
import com.demo.servletpath.filter.autologin.domain.UserFilter;

import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/22.
 */
public class UserFilterService {
	UserFilterDao userFilterDao = new UserFilterDao();

	public UserFilter login(String username, String password) throws SQLException {
		UserFilter user = userFilterDao.findUser(username, password);
		return user;
	}
}
