package com.demo.servletpath.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 解析get方式乱码的问题
        String username = request.getParameter("username");

        username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] love = request.getParameterValues("love");
        String city = request.getParameter("city");
        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().write("username=" + username + "\npassword=" + password
//                + "\nsex" + sex + "\ncity=" + city + "\nlove" + love);
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        for (String key : keys) {
            String[] values = parameterMap.get(key);
            System.out.println(Arrays.toString(values));
        }

    }
}
