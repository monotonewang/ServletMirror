package com.demo.servletpath.enhance2.permission.servlet;

import com.demo.servletpath.enhance2.permission.BookServiceFactory;
import com.demo.servletpath.enhance2.permission.domain.User;
import com.demo.servletpath.enhance2.permission.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2017/1/4.
 */
@WebServlet(name = "ServletBooks", urlPatterns = "/ServletBooks")
public class ServletBooks extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("add")) {
			addBooks(request, response);
		} else if (method.equals("update")) {
			updateBooks(request, response);
		} else if (method.equals("delete")) {
			deleteBooks(request, response);
		} else if (method.equals("search")) {
			searchBooks(request, response);
		}
	}

	private void searchBooks(HttpServletRequest request, HttpServletResponse response) {
		BookService service = BookServiceFactory.getInstance();
		User user = (User) request.getSession().getAttribute("user");
		try {
			service.searchBook(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void deleteBooks(HttpServletRequest request, HttpServletResponse response) {
		BookService service = BookServiceFactory.getInstance();
		User user = (User) request.getSession().getAttribute("user");
		try {
			service.deleteBook(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateBooks(HttpServletRequest request, HttpServletResponse response) {
		BookService service = BookServiceFactory.getInstance();
		User user = (User) request.getSession().getAttribute("user");
		try {
			service.updateBook(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void addBooks(HttpServletRequest request, HttpServletResponse response) {
		BookService service = BookServiceFactory.getInstance();
		User user = (User) request.getSession().getAttribute("user");
		try {
			//获取用户，到数据库里面查
			service.addBook(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
