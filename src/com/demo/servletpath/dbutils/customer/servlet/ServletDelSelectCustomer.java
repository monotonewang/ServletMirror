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
 * Created by 7 on 2016/12/19.
 */
@WebServlet(name = "ServletDelSelectCustomer")
public class ServletDelSelectCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1.得到所有要删除的客户的id
		String[] id = request.getParameterValues("ck");
//		for (String ss: id) {
//			System.out.println("id=" + ss);
//		}
		CustomService customerService = new CustomService();
		try {
			int[] ints = customerService.delSelect(id);
			for (int ss : ints) {
				System.out.println("int=" + ss);
			}
			//重定向，查询剩余的客户信息
			response.sendRedirect(request.getContextPath() + "/ServletShowAllCustomer");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("批量删除失败");

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
