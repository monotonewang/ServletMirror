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
@WebServlet(name = "ServletSessionId")
public class ServletSessionId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session域对象
        HttpSession session = request.getSession();
        session.setAttribute("username","小风");
        //EC2CD3897FD6AF24111A6B10B132DB0B
        System.out.println(session.getId());
    }
}
