package com.demo.servletpath.enhance2.servlet3.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2017/1/3.
 */
//Servlet3.0--> J2EE 6.0 Tomcat 7.0 Jdk 1.6
@WebServlet(urlPatterns = {"/Servlet3Config"}, name = "Servlet3Config", initParams = {@WebInitParam(name = "username", value = "tom"), @WebInitParam(name = "password", value = "p")})
public class Servlet3Config extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletConfig servletConfig = this.getServletConfig();
		String username = servletConfig.getInitParameter("username");
		String password = servletConfig.getInitParameter("password");
		response.getWriter().write("username=" + username + "password=" + password);

	}
}
