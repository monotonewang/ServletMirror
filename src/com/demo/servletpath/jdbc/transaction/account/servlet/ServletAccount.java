package com.demo.servletpath.jdbc.transaction.account.servlet;

import com.demo.servletpath.jdbc.transaction.account.exception.AccountException;
import com.demo.servletpath.jdbc.transaction.account.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/12.
 */
@WebServlet(name = "ServletAccount")
public class ServletAccount extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;chasetset=UTF-8");
		String accountIn = request.getParameter("accountIn");
		String accountOut = request.getParameter("accountOut");
		double money = Double.parseDouble(request.getParameter("money"));
		System.out.println("accountIn="+accountIn+"accountOut="+accountOut+"money="+money);
		//2.调用 service。finsh transfer money
		AccountService accountService=new AccountService();
		try {
			try {
				accountService.account(accountIn,accountOut,money);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
			response.getWriter().write("transfer success");
		} catch (AccountException e) {
			e.printStackTrace();
			response.getWriter().write("transfer fail");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
