package com.demo.servletpath.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/22.
 */
@WebServlet(name = "ServletFilter1")
public class ServletFilter1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletFilter1 is running");
		//转发
//		request.getRequestDispatcher("/ServletFilter2").forward(request, response);

		response.sendRedirect("/ServletMirror/ServletFilter2");
	}
}
