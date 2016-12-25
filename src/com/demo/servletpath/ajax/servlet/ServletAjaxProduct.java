package com.demo.servletpath.ajax.servlet;

import com.demo.servletpath.ajax.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangTest on 2016/12/25.
 */
@WebServlet(name = "ServletAjaxProduct")
public class ServletAjaxProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Product> products=new ArrayList<>();
        products.add(new Product(1,"洗衣机",1212));
        products.add(new Product(2,"手机",1212));
        products.add(new Product(3,"冰箱",5858));
        products.add(new Product(4,"空调",1616));
        products.add(new Product(5,"电视机",8989));
        PrintWriter out = response.getWriter();
        StringBuilder builder = new StringBuilder();

        builder.append("<table border='1'><tr><td>商品编号</td><td>商品名称</td><td>商品价格</td></tr>");
        for (Product p : products) {
            builder.append("<tr><td>" + p.getId() + "</td><td>" + p.getName()
                    + "</td><td>" + p.getMoney() + "</td></tr>");
        }

        builder.append("</table>");

        out.print(builder.toString());
        out.flush();
        out.close();
    }
}
