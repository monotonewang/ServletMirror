package com.demo.servletpath.enhance2.servlet3.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by 7 on 2017/1/3.
 */
@WebServlet(name = "Servlet3UpLoad", urlPatterns = {"/Servlet3UpLoad"})
@MultipartConfig
public class Servlet3UpLoad extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 解决乱码

		Part part = request.getPart("f"); // 得到上传文件信息.

//		request.getParts();

		// 获取上传文件名称
		String cd = part.getHeader("Content-Disposition");

//		System.out.println(cd); // form-data; name="f";
		// filename="C:\Users\Administrator\Desktop\鎹曡幏.PNG"

		String filename = cd.substring(cd.lastIndexOf("=") + 2, cd.length() - 1);

		System.out.println(filename);

		part.write("C:/upload/" + filename);// complete file upload
	}
}
