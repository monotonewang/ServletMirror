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
 * Created by 7 on 2016/12/12.
 */
@WebServlet(name = "ServletUpdateCustomer")
public class ServletUpdateCustomer extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("doPost test");
		// 处理请求编码，
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		Customer customer = new Customer();
		DateConverter dc = new DateConverter(); // 这是一个日期类型转换器.
		dc.setPattern("yyyy-MM-dd");
		try {
			ConvertUtils.register(dc, java.util.Date.class);
			BeanUtils.populate(customer, parameterMap);
			System.out.print("ServletUpdateCustomer="+customer);
			CustomService customService = new CustomService();
			try {
				int res = customService.updateCustomer(customer);
				if (res == 1) {//success
					//转发
					request.setAttribute("cs", customer);
					response.sendRedirect(request.getContextPath() +"/ServletShowAllCustomer");
//						request.getRequestDispatcher(request.getContextPath() + "/ServletShowAllCustomer").forward(request, response);
				} else {//failed
					System.out.println("update failed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("doGet test");
		doPost(request, response);
	}
}
