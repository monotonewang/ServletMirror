package com.demo.servletpath.upload.web.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by 7 on 2016/12/20.
 */
@WebServlet(name = "ServletUploadByUtil")
public class ServletUploadByUtil extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.创建 工厂类
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		//2.创建
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			// 底层通过request获取数据，进行解析，将解析的数据封装到List<FileItem>
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					// 这就是得到了<input type="text" name="content">这样的组件
//					String fieldName = fileItem.getFieldName();
//					System.out.println("fieldName=" + fieldName);
//
//					String name = fileItem.getName();
//					System.out.println("name=" + name);
//
//					String msg = fileItem.getString();
//					System.out.println("msg=" + msg);
				} else {
					// 这就是得到了<input type="file"> 这样的组件.
//					String fieldName = fileItem.getFieldName();
//					System.out.println("上传组件的名称:" + fieldName);
					//
					String name = fileItem.getName(); // 上传文件名称
					System.out.println(name);
					name = name.substring(name.lastIndexOf("\\") + 1);
//					System.out.println("上传组件:" + name);
					//得到文件里面的内容
//					String msg = fileItem.getString();
//					System.out.println(msg);

//					 获取上传文件内容,完成文件 上传操作
//					 InputStream is = item.getInputStream();
//					 byte[] b = new byte[1024];
//					 int len = -1;
					FileOutputStream fos = new FileOutputStream("C:/upload/"
							+ name);
//					 while ((len = is.read(b)) != -1) {
//
//					 fos.write(b, 0, len);
//
//					 }
//					 fos.close();
//					 is.close();

					IOUtils.copy(fileItem.getInputStream(), fos);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}
}
