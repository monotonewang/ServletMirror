package com.demo.servletpath.enhance2.excel.servlet;

import com.demo.servletpath.enhance2.excel.bean.User;
import com.demo.servletpath.enhance2.excel.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 7 on 2016/12/30.
 */
public class UserExeclServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html:Charset=UTF-8");
		UserService service = new UserService();
		try {
			List<User> users = service.findAll();
//			System.out.println(users);
			req.setAttribute("user", users);
			req.getRequestDispatcher("/jsp/enhance2/allUsers.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
