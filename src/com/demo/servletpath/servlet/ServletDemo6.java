package com.demo.servletpath.servlet;

import javax.servlet.ServletConfig;
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
@WebServlet(name = "ServletDemo6")
//servletConfig
public class ServletDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getInitParameter("username");
        String password = getInitParameter("password");
        response.getWriter().write(username+"pwd="+password);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = getInitParameter("username");
        String password = getInitParameter("password");
        response.getWriter().write(username+"pwd="+password);
        ServletConfig servletConfig = getServletConfig();
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            response.getWriter().write("\n"+s+"pwsd="+getInitParameter(s));
            System.out.println(s+" "+getInitParameter(s));
        }
    }
}
