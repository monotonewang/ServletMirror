package com.demo.servletpath.jspel.servlet;

import com.demo.servletpath.jspel.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by 7 on 2016/12/6.
 */
@WebServlet(name = "ServletJspELUser")
public class ServletJspELUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 获取请求参数，创建User对象，设置值。
        /**
         *
         * 	// 获取表单的内容
         *
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         // 创建User对象，set设置值
         ListenerUser user = new ListenerUser();
         user.setUsername(username);
         user.setPassword(password);
         */

        // 获取输入的数据
        Map<String, String []> map = request.getParameterMap();
        // 创建User对象
        User user = new User();
        // 自己编写封装数据的方法
        try {
            populate(map,user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 完成数据封装
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
    /**
     * 完成的数据
     * @param map
     * @param user
     * @throws Exception
     */
    private void populate(Map<String, String[]> map, User user) throws Exception {
        BeanInfo info = Introspector.getBeanInfo(user.getClass());
        // 获取属性的描述
        PropertyDescriptor[] pds = info.getPropertyDescriptors();
        // 循环遍历
        for (PropertyDescriptor pd : pds) {
            // 获取到属性的名称
            String name = pd.getName();
            // map的key
            if(map.containsKey(name)){
                // 获取属性的写的方法
                Method m = pd.getWriteMethod();
                // 执行之
                m.invoke(user, map.get(name)[0]);
            }
        }
    }
}
