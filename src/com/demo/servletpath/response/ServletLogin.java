package com.demo.servletpath.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("admin")) {
            response.getWriter().write("success");
            response.sendRedirect("/ServletMirror/response/refresh.html");
        } else {
//            response.setStatus(302);
//            response.setHeader("location", "/ServletMirror/response/login.html");
            response.sendRedirect("/ServletMirror/response/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
