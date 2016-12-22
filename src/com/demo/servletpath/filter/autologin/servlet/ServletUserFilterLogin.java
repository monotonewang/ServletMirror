package com.demo.servletpath.filter.autologin.servlet;

import com.demo.servletpath.filter.autologin.domain.UserFilter;
import com.demo.servletpath.filter.autologin.service.UserFilterService;
import com.demo.servletpath.filter.autologin.utils.Md5Utils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/22.
 */
@WebServlet(name = "ServletUserFilterLogin")
public class ServletUserFilterLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.FilterEncoding set encoding utf-8
		UserFilter userFilter = new UserFilter();
		try {
			BeanUtils.populate(userFilter, request.getParameterMap());
			//2.call service method
			UserFilterService service = new UserFilterService();
			UserFilter user = service.login(userFilter.getUsername(), Md5Utils.md5(userFilter.getPassword()));
			if (user != null) {
				//login success--> value on
				String autoLogin = request.getParameter("autoLogin");
				if (autoLogin.equals("on")) {
					//查找里面的之前是否有cookie
					// 使用cookie回写
					Cookie cookie1 = new Cookie("autologin", "on");
					cookie1.setValue(user.getUsername() + "::"+user.getPassword());
					cookie1.setMaxAge(60 * 60 * 24 * 10);//存储10天
					cookie1.setPath("/");
					//回写
					response.addCookie(cookie1);
				}
				request.getSession().setAttribute("user", user);
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/jsp/filter/loginSuccess.jsp");
			} else {
				request.setAttribute("login.msg", "username or password failed");
				request.getRequestDispatcher("/jsp/filter/userLogin.jsp").forward(request, response);
			}
		} catch (IllegalAccessException | InvocationTargetException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("login.msg", "登录异常");
			request.getRequestDispatcher("/jsp/filter/userLogin.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
