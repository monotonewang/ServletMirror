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
 * Created by 7 on 2016/12/12.
 */
@WebServlet(name = "ServletShowAllCustomer")
public class ServletShowAllCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		CustomService customService = new CustomService();
		try {
			List<Customer> customerList = customService.showAllCustomer();
			if (customerList != null) {
				System.out.println(customerList);
			}else{
				System.out.println("null");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
