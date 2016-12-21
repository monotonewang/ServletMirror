package com.demo.servletpath.servlet;

import com.demo.servletpath.jdbc.dao.Dao;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by WangTest on 2016/11/26.
 * This is create by git command--git test test test
 */
public class ServletDemo1 implements Servlet {
    Dao dao = new Dao();
    private String string="hello demo1";

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.getWriter().write(string);
//        dao.getForList()


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
