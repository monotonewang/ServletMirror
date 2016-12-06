package com.demo.servletpath.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/5.
 */
@WebServlet(name = "ServletLoginSession")
public class ServletLoginSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String code1 = (String) request.getSession().getAttribute("code");

        System.out.println(code1);

        // 获取表单中的验证码
        String code2 = request.getParameter("code");
        // 是否相同
        if(code2 != null && code1.equals(code2)){
            response.getWriter().write("success");
        }else{
            // 如果不相同，返回错误的信息
            // 转发
            request.setAttribute("msg", "验证码输入错误");
            request.getRequestDispatcher("/jsp/loginSession.jsp").forward(request, response);
        }
    }
}
