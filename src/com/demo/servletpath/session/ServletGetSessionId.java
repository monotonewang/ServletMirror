package com.demo.servletpath.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/6.
 */
@WebServlet(name = "ServletGetSessionId")
public class ServletGetSessionId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 手动传入jsessionid=DD64756D56885AF87E883B887BF77E6C
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("username="+username);
    }
}
