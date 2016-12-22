package com.demo.servletpath.filter.autologin.filter;

import com.demo.servletpath.filter.autologin.domain.UserFilter;
import com.demo.servletpath.filter.autologin.service.UserFilterService;
import com.demo.servletpath.filter.autologin.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

/**
 * Created by 7 on 2016/12/22.
 */
@WebFilter(filterName = "FilterAutoLogin")
public class FilterAutoLogin implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//查看用户是否是手动登录操作
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = requestURI.substring(contextPath.length());

//		System.out.println("request=" + requestURI);	/ServletMirror/jsp/filter/userLogin.jsp
//		System.out.println("contextPath=" + contextPath); /ServletMirror
//		System.out.println("path=" + path);  /jsp/filter/userLogin.jsp

		if (!path.equals("/jsp/filter/userLogin.jsp") || path.equals("/ServletUserFilterLogin")) {
			// 判断用户没有登录，才进行自动登录.
			UserFilter user = (UserFilter) request.getSession().getAttribute("user");
			if (user == null) {
				// 2.1 得到cookie中的username,password
				Cookie cookie = CookieUtils.findCookieByName(request.getCookies(), "autologin");

				if (cookie != null) {
					// 找到了,进行自动登录
					//获取cookie中的value cookie解码
					String username = URLDecoder.decode(cookie.getValue().split("::")[0],"UTF-8");
//					String password = URLDecoder.decode(cookie.getValue().split("::")[1], "UTF-8");
					String password = cookie.getValue().split("::")[1];
					UserFilterService service = new UserFilterService();
					UserFilter userFilter;
					try {
						userFilter = service.login(username, password);
						if (userFilter != null) {
							// 查找到了用户，进行自动登录
//							System.out.println("auto login");
							request.getSession().setAttribute("user", userFilter);
							response.sendRedirect(request.getContextPath()
									+ "/jsp/filter/loginSuccess.jsp");
							return;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
