package com.demo.servletpath.mvpdemo.action;

import com.demo.servletpath.mvpdemo.service.RegService;
import com.demo.servletpath.mvpdemo.utils.MyXmlUtil;
import com.demo.servletpath.mvpdemo.vo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by 7 on 2016/12/7.
 */
@WebServlet(name = "ServletMvpRegister")
public class ServletMvpRegister extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 1.获取参数列表
         * 2.需要把数据封装到JavaBean中，使用BeanUtils开发包
         * 3.处理数据，调用另一个JavaBean中
         * 4.把结果返回到页面中
         */
        // 设置request缓冲区的编码(post)
        request.setCharacterEncoding("UTF-8");
        // 设置字符中文乱码
        response.setContentType("text/html;charset=UTF-8");

        // 获取session中的验证码
        String sessCode = (String) request.getSession().getAttribute("sessCode");
        // 获取页面的验证码
        String reqCode = request.getParameter("code");
        // 判断
        if(reqCode == null || !reqCode.equals(sessCode)){
            // 转发到注册页面
            request.setAttribute("msg", "验证码输入错误");
            request.getRequestDispatcher("/jsp/mvpdemo/reg.jsp").forward(request, response);
            return;
        }

        // 获取请求头
        String referer = request.getHeader("referer");
        if(referer == null || !referer.endsWith("reg.jsp")){
            // 做处理
            // 获取虚拟路径
            // request获取客户机的信息（重定向）
            response.sendRedirect(request.getContextPath()+"/jsp/mvpdemo/reg.jsp"); // 加项目
            return;
        }

        // 获取参数列表
        Map<String, String []> map = request.getParameterMap();
        // 获取参数列表
        User user = new User();
        // 封装数据（BeanUtils）
        try {
            BeanUtils.populate(user, map);
            // 处理注册业务的类
            RegService reg = new RegService();
            // 完成注册
            int flag = reg.regUser(user);
            System.out.println("flag="+flag);
            if(flag == MyXmlUtil.NAMEEXIST){
                // 用户名重名了
                // 转发注册页面
                request.setAttribute("msg", "用户名已存在");
                // 转发
                request.getRequestDispatcher("/jsp/mvpdemo/reg.jsp").forward(request, response);

            }else if(flag == MyXmlUtil.EMAILEXIST){
                // 邮箱重名了
                request.setAttribute("msg", "邮箱已存在");
                // 转发
                request.getRequestDispatcher("/jsp/mvpdemo/reg.jsp").forward(request, response);

            }else if(flag == MyXmlUtil.SUCCESS){
                // 注册成功
                // 跳转登陆页面
                // 注册成功
                response.getWriter().write("注册成功了");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
