package com.demo.servletpath.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletReponseHeader")
public class ServletReponseHeader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向
        //向页面输出内容--
        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(302);
        response.setHeader("location", "/ServletMirror/html/path.html");
    }
}
