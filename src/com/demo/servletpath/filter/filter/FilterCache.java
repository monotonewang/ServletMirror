package com.demo.servletpath.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/22.
 */
@WebFilter(filterName = "FilterCache")
public class FilterCache implements Filter {
	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		// 1.强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 2.操作
		//		强制缓存从服务器上获取新的页面
		response.setHeader("pragma", "no-cache");
		//		在任何环境下缓存不保存任何页面
		response.setHeader("cache-control", "no-store");
		response.setDateHeader("expires", 0);

		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
