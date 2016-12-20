package com.demo.servletpath.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 7 on 2016/12/20.
 * 文件上传的原理
 */
@WebServlet(name = "ServletUpLoadTheory")
public class ServletUpLoadTheory extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//通过request获取一个字节输入流，将所有的请求正文信息读取到，打印到控制台。
		InputStream is = request.getInputStream();

		byte[] b = new byte[1024];
		int len = -1;

		while ((len = is.read(b)) != -1) {

			System.out.print(new String(b, 0, len));

		}
		is.close();
	}
}
