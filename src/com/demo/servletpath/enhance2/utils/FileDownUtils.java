package com.demo.servletpath.enhance2.utils;

import com.demo.servletpath.enhance2.servlet.ServletExcelPrint;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by 7 on 2016/12/30.
 */
public class FileDownUtils {
	public static void downUserExcel(ServletExcelPrint servletExcelPrint, HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
		File file = new File(fileName);

		if (file.exists()) {
			// /文件存在，完成下载

			// 下载注意事项1--设置下载文件的mimeType
			String mimeType = servletExcelPrint.getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);

			//解决浏览器的文件名称乱码
			String agent = request.getHeader("user-agent");
			if (agent.contains("MSIE")) {
				// IE浏览器
				fileName = URLEncoder.encode(fileName, "utf-8");

			} else if (agent.contains("Firefox")) {
				// 火狐浏览器
				BASE64Encoder base64Encoder = new BASE64Encoder();
				fileName = "=?utf-8?B?"
						+ base64Encoder.encode(fileName.getBytes("utf-8"))
						+ "?=";
			} else {
				// 其它浏览器
				fileName = URLEncoder.encode(fileName, "utf-8");
			}

			// 下载注意事项2--永远是下载
			response.setHeader("content-disposition", "attachment;filename="
					+ fileName);

			FileInputStream fis = new FileInputStream(file);
			OutputStream os = response.getOutputStream();//将要下载的文件回写到浏览器端
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = fis.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				os.flush();
			}
			os.close();
			fis.close();
		}
	}

	public static void delFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			boolean delete = file.delete();
		}
	}
}
