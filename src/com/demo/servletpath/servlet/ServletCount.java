package com.demo.servletpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * show website visit times
 * Created by WangTest on 2016/11/27.
 */
@WebServlet(name = "ServletCount")
public class ServletCount extends HttpServlet {
    /**
     * 实例一被创建，就调用init方法初始化
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        int count = 0;
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("count", count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        int count = (int) servletContext.getAttribute("count");
        count++;
        servletContext.setAttribute("count", count);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<h3>visit&nbsp="+ + (count++) + "times</h3>");
    }
}
