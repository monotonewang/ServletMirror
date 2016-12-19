package com.demo.servletpath.dbutils.customer.servlet;

import com.demo.servletpath.dbutils.customer.domain.Customer;
import com.demo.servletpath.dbutils.customer.service.CustomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 7 on 2016/12/19.
 */
@WebServlet(name = "ServletSimpleSelectCustomer")
public class ServletSimpleSelectCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String field = request.getParameter("field");
		String msg = request.getParameter("msg");
		System.out.println("field=" + field + "msg=" + msg);
		CustomService customService = new CustomService();
		try {
			List<Customer> customerList = customService.simpleSelect(field, msg);
			request.setAttribute("cs", customerList);

			request.getRequestDispatcher("/jsp/dbutils/showCustomer.jsp").forward(request,
					response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("条件查询失败");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
