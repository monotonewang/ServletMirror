package com.demo.servletpath.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by WangTest on 2016/12/3.
 */
@WebServlet(name = "ServletSession")
public class ServletSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断是否是第一次登陆，
        //用于调试服务器errorpage 500
//        int a=10/0;
        String id = request.getParameter("id");
        String names[] ={"手电筒","冰箱","电脑","电视机","电话"};
        if(id==null){
            return;
        }
        int idx=Integer.parseInt(id);
        //获取商品名称
        String name=names[idx-1];
        //从session中获取购物车
        HttpSession session = request.getSession();
        //获取购物车
        HashMap<String,Integer> cartMap = (HashMap) session.getAttribute("cart");
           if(cartMap==null){
               //创建购物车
               cartMap=new HashMap<>();
               //第一次访问
               cartMap.put(name,1);
               session.setAttribute("cart",cartMap);
           }else{
               //不是第一次访问,是否包含该值
                if(cartMap.containsKey(name)){
                    //取出数量 +1.存入购物车
                    Integer integer = cartMap.get(name);
                    integer++;
                    cartMap.put(name,integer);
                    session.setAttribute(name,cartMap);
                }else{
                    //不包含
                    cartMap.put(name,1);
                    session.setAttribute("cart",cartMap);
                }
           }
           response.setContentType("text/html;charset=UTF-8");
           response.getWriter().write("<h3><a href='/ServletMirror/jsp/cartSession.jsp'>继续购物</a><a href='/ServletMirror/jsp/paySession.jsp'>结算</a></h3>");

    }
}
