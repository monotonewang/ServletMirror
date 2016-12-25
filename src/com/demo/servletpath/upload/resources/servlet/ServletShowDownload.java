package com.demo.servletpath.upload.resources.servlet;

import com.demo.servletpath.upload.resources.domain.Resource;
import com.demo.servletpath.upload.resources.service.ResourceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by WangTest on 2016/12/25.
 */
@WebServlet(name = "ServletShowDownload")
public class ServletShowDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResourceService resource=new ResourceService();
        try {
            List<Resource> list=resource.findAll();
            request.setAttribute("rs",list);
            request.getRequestDispatcher("/jsp/upload/resource/download.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
