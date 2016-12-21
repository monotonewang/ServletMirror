package com.demo.servletpath.dbutils.customer.servlet;

import com.demo.servletpath.dbutils.customer.service.CustomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/12.
 */
@WebServlet(name = "ServletDelByIdCustomer")
public class ServletDelByIdCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		CustomService customService = new CustomService();
		String id = request.getParameter("id");
		try {
			int res = customService.delCustomerById(id);
			if (res == 1) {
				System.out.println(request.getContextPath());//--/ServletMirror
				//重定向
				response.sendRedirect(request.getContextPath()+"/ServletShowAllCustomer");
			} else {
				System.out.println("failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
