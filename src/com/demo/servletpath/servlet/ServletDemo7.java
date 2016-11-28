package com.demo.servletpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletDemo7")
public class ServletDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String encoding = servletContext.getInitParameter("encoding");
        response.getWriter().write("编码" + encoding + "\n");
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = servletContext.getInitParameter(name);
            response.getWriter().write("name=" + name + "\n" + "value=" + value);
        }

        String realPath = servletContext.getRealPath("/WEB_INF/classes/com/demo/jdbc/pro/jdbc.properties");
        if (realPath == null) {
            realPath = "null";

        }
        response.getWriter().write(realPath);
    }
}
