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

/**
 * Created by 7 on 2016/12/12.
 */
@WebServlet(name = "ServletFindIdCustomer")
public class ServletFindIdCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
//		System.out.println("ServletFindIdCustomer--id="+id);
		CustomService customService=new CustomService();
		try {
			Customer customer = customService.findCustomerById(id);
			if(customer!=null){
				//转发
				request.setAttribute("cs",customer);
				request.getRequestDispatcher("/jsp/dbutils/customerInfo.jsp").forward(request,response);
//				System.out.println(customer);
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
