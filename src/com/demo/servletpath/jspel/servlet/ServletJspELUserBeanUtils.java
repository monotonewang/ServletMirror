package com.demo.servletpath.jspel.servlet;

import com.demo.servletpath.jspel.bean.User;
import com.demo.servletpath.jspel.utils.MyDateConverter;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by 7 on 2016/12/6.
 */
@WebServlet(name = "ServletJspELUserBeanUtils")
public class ServletJspELUserBeanUtils extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        Map<String, String[]> map = request.getParameterMap();
        // 创建User对象
        User user = new User();

        // 完成注册
        ConvertUtils.register(new MyDateConverter(), Date.class);

        // 完成封装
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 打印
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getMoney());
        System.out.println(user.getBirthday());
    }
}
