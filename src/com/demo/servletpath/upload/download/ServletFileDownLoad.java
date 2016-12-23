package com.demo.servletpath.upload.download;

import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by 7 on 2016/12/20.
 */
@WebServlet(name = "ServletFileDownLoad")
public class ServletFileDownLoad extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		System.out.println("filename="+filename);
//		filename = new String(filename.getBytes("ISO8859-1"), "UTF-8");// 解决中文乱码
		File file = new File("C:/upload/" + filename);
		System.out.println(file.getAbsolutePath());
		if (file.exists()) {

			// 下载注意事项1--设置下载文件的mimeType
			String mimeType = this.getServletContext().getMimeType(filename);
			response.setContentType(mimeType);

			String agent = request.getHeader("user-agent");
			if (agent.contains("MSIE")) {
				// IE浏览器
				filename = URLEncoder.encode(filename, "utf-8");

			} else if (agent.contains("Firefox")) {
				// 火狐浏览器
				BASE64Encoder base64Encoder = new BASE64Encoder();
				filename = "=?utf-8?B?"
						+ base64Encoder.encode(filename.getBytes("utf-8"))
						+ "?=";
			} else {
				// 其它浏览器
				filename = URLEncoder.encode(filename, "utf-8");
			}

			// 下载注意事项2--永远是下载
			response.setHeader("content-disposition", "attachment;filename="
					+ filename);

			FileInputStream fis=new FileInputStream(file);
			OutputStream os = response.getOutputStream();//将要下载的文件回写到浏览器端
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = fis.read(bytes)) != -1) {
				os.write(bytes,0,len);
				os.flush();
			}
			os.close();
			fis.close();
		}
	}
}
