package com.demo.servletpath.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletNoCache")
public class ServletNoCache extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //禁用浏览器缓存
        response.setHeader("Cache-Contorl","no-cache");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Expires","-1");
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string=simpleDateFormat.format(date);
        response.getWriter().write(string);
    }
}
