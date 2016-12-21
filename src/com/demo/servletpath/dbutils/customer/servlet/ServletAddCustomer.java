package com.demo.servletpath.dbutils.customer.servlet;

import com.demo.servletpath.dbutils.customer.domain.Customer;
import com.demo.servletpath.dbutils.customer.service.CustomService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by 7 on 2016/12/19.
 */
@WebServlet(name = "ServletAddCustomer")
public class ServletAddCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单的请求数据
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Customer customer = new Customer();
		DateConverter dc = new DateConverter(); // 这是一个日期类型转换器.
		dc.setPattern("yyyy-MM-dd");

		ConvertUtils.register(dc, java.util.Date.class);
		try {
			BeanUtils.populate(customer, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		CustomService customService = new CustomService();
		try {
			int i = customService.addCustomer(customer);
			// 添加成功
			response.sendRedirect(request.getContextPath() + "/ServletShowAllCustomer");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("add.message", "添加客户信息失败");
			request.getRequestDispatcher("/jsp/dbutils/addCustomer.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
