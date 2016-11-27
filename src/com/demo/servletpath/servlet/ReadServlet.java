package com.demo.servletpath.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ReadServlet")
public class ReadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Properties properties = new Properties();
        properties.load(getServletContext().getResourceAsStream("/WEB-INF/classes/com/demo/servletpath/db.properties"));
        String realPath = getServletContext().getRealPath("/WEB-INF/classes/com/demo/servletpath/db.properties");
//        properties.load(getServletContext().getResourceAsStream("/WEB-INF/classes/com/demo/servletpath/servlet/proper/db.properties"));
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("realPath="+realPath+"\n");
        response.getWriter().write("username="+username+"\tpassword="+password);

    }
}
