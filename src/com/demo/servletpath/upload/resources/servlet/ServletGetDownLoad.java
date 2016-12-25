package com.demo.servletpath.upload.resources.servlet;

import com.demo.servletpath.upload.resources.domain.Resource;
import com.demo.servletpath.upload.resources.service.ResourceService;
import org.apache.commons.io.FileUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;

/**
 * Created by WangTest on 2016/12/25.
 */
@WebServlet(name = "ServletGetDownLoad")
public class ServletGetDownLoad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.先获取参数
        String id = request.getParameter("id");

        //2.调用service
        ResourceService resourceService = new ResourceService();
        try {
            Resource res = resourceService.findById(id);
            File file = new File(res.getSavePath(), res.getUuidName());
            if (file.exists()) {//资源存在。写回到response
                byte[] bytes = FileUtils.readFileToByteArray(file);//将文件读到byte array中
                // 下载注意事项1--设置下载文件的mimeType
                String filename = res.getRealName();
                String mimeType = this.getServletContext().getMimeType(res.getRealName());
                response.setContentType(mimeType);

                //解决浏览器的文件名称乱码
                String agent = request.getHeader("user-agent");
                filename = configBrowser(filename, agent);

                // 下载注意事项2--永远是下载
                response.setHeader("content-disposition", "attachment;filename="
                        + filename);

                response.getOutputStream().write(bytes);
            } else {
                throw new RuntimeException("res not find");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String configBrowser(String filename, String agent) throws UnsupportedEncodingException {
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
        return filename;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
