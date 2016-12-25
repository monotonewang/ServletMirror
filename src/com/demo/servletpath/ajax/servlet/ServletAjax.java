package com.demo.servletpath.ajax.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WangTest on 2016/12/25.
 */
@WebServlet(name = "ServletAjax")
public class ServletAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        response.getWriter().write("hello ajax post=" + username);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().write("hello ajax");
//        response.getWriter().close();

        String tom = request.getParameter("name");
        response.getWriter().write("hello ajax=" + tom);
    }
}
