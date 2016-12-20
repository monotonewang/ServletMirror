package com.demo.servletpath.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletDownLoad")
public class ServletDownLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取文件。读入流
        String path = getServletContext().getRealPath("/img/house.jpg");
        String filename = null;
        int index = path.lastIndexOf("\\");
        if (index != -1) {
            filename = path.substring(index + 1);
        }

        // 判断是什么浏览器	Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)
        // Mozilla/5.0 (Windows NT 6.1; WOW64; rv:30.0) Gecko/20100101 Firefox/30.0
        String agent = request.getHeader("ListenerUser-Agent");
        // System.out.println(agent);
        if(agent.contains("MSIE")){
            filename = URLEncoder.encode(filename,"UTF-8");
        }
        if(filename!=null) {
            // 设置头信息
            response.setHeader("Content-Disposition", "attachment;filename"+filename);

            String remoteAddr = request.getRemoteAddr();
            System.out.println("path=" + path + "\nremoteAddr" + remoteAddr + "\nfilename" + filename);
            InputStream inputStream = new FileInputStream(path);
            //通过response读出到客户端
            OutputStream outputStream = response.getOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            inputStream.close();
//        outputStream.close();服务器会管理流
        }
    }
}
