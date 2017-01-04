package com.demo.servletpath.enhance2.permission.servlet;

import com.demo.servletpath.enhance2.permission.domain.User;
import com.demo.servletpath.enhance2.permission.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 7 on 2017/1/4.
 */
@WebServlet(name = "ServletLoginPermission", urlPatterns = "/ServletLoginPermission")
public class ServletLoginPermission extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService service = new UserService();
		User user = null;
		try {
			user = service.login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/jsp/enhance2/book.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
