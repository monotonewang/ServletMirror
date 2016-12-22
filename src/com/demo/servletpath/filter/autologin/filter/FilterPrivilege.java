package com.demo.servletpath.filter.autologin.filter;

import com.demo.servletpath.filter.autologin.domain.UserFilter;
import com.demo.servletpath.filter.autologin.exception.PrivilegeException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by WangTest on 2016/12/23.
 */
@WebFilter(filterName = "FilterPrivilege")
public class FilterPrivilege implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
// 1.强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        //2.首先进行判断哪些需要权限
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String path = uri.substring(contextPath.length());
//        System.out.println("path"+path);
        //3.对需要进行权限控制的页面进行处理
        if (path.equals("/ServletFilterBookSearch") || path.equals("/ServletFilterBookUpdate") || path.equals("/ServletFilterBookDelete") || path.equals("/ServletFilterBookAdd")) {
            // 2.操作
            UserFilter user = (UserFilter) request.getSession().getAttribute("user");
            if (user == null) {
                throw new PrivilegeException("权限不足");
            }
            //判断用户的角色是否可以访问资源路径
            if ("admin".equals(user.getRole())) {//admin角色
                if (path.equals("/ServletFilterBookUpdate") || path.equals("/ServletFilterBookDelete") || path.equals("/ServletFilterBookAdd")) {
                    throw new PrivilegeException("admin权限不足");
                }
            } else {//user角色
                if (path.equals("/ServletFilterBookSearch")) {
                    throw new PrivilegeException("user权限不足");
                }
            }
        }
        //		强制缓存从服务器上获取新的页面
//        response.setHeader("pragma", "no-cache");
//        //		在任何环境下缓存不保存任何页面
//        response.setHeader("cache-control", "no-store");
//        response.setDateHeader("expires", 0);
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
