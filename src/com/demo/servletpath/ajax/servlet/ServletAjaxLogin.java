package com.demo.servletpath.ajax.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangTest on 2016/12/25.
 */
@WebServlet(name = "ServletAjaxLogin")
public class ServletAjaxLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("name");
        List<String> name = new ArrayList<>();
        name.add("tom");
        name.add("fox");
        name.add("james");
        name.add("张三");
        if (name.contains(username)) {
            response.getWriter().write("<font color='red'>用户名已经占用</font>");
        } else {
            response.getWriter().write("<font color='green'>用户名可以用</font>");
        }
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
