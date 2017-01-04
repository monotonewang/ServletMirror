package com.demo.servletpath.enhance2.proxy.encoding;

import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by 7 on 2017/1/4.
 */
@WebServlet(name = "ServletProxyLogin", urlPatterns = "/ServletProxyLogin")
public class ServletProxyLogin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);
	}

	@Test
	public void testEncoding() throws UnsupportedEncodingException {
		byte[] b = {-28, -72, -83, -27, -101, -67};
		String s = new String(b, "utf-8");
		System.out.println(s);
	}
}
