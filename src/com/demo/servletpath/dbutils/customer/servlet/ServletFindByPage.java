package com.demo.servletpath.dbutils.customer.servlet;

import com.demo.servletpath.dbutils.customer.domain.Customer;
import com.demo.servletpath.dbutils.customer.domain.PageBean;
import com.demo.servletpath.dbutils.customer.service.CustomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by WangTest on 2016/12/19.
 */
@WebServlet(name = "ServletFindByPage")
public class ServletFindByPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.默认访问第一页
        int pageNum = 1;
        //获取前端提交过来的额数据
        String _pageNum = request.getParameter("pageNum");
        if (_pageNum != null) {
            pageNum = Integer.parseInt(_pageNum);
        }

        //2.每页条数，认为定义
        int currentPage = 5;
        String _currentPage = request.getParameter("currentPage");
        if (_currentPage != null) {
            currentPage = Integer.parseInt(_currentPage);
        }

        //3.调用service,完成查询操作
        CustomService customService = new CustomService();
        try {
            PageBean page = customService.findByPage(pageNum, currentPage);
            //4.将数据存储到request域中，
            request.setAttribute("pb", page);
            request.getRequestDispatcher("/jsp/dbutils/showCustomerByPage.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
