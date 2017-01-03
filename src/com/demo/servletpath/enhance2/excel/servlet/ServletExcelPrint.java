package com.demo.servletpath.enhance2.excel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.demo.servletpath.enhance2.excel.utils.ExcelUtils.getUserExcel;
import static com.demo.servletpath.enhance2.excel.utils.FileDownUtils.delFile;
import static com.demo.servletpath.enhance2.excel.utils.FileDownUtils.downUserExcel;

/**
 * Created by 7 on 2016/12/30.
 */
@WebServlet(name = "ServletExcelPrint")
public class ServletExcelPrint extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = "C://user.xls";
		getUserExcel(fileName);
		fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");// 解决中文乱码
		downUserExcel(this, request, response, fileName);
		//删除服务器端的文件
		delFile(fileName);
	}

}
