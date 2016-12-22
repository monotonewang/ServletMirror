package com.demo.servletpath.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/22.
 */
@WebFilter(filterName = "FilterImageCache")
public class FilterImageCache implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		// 1.强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// 2.操作
		response.setDateHeader("expires", System.currentTimeMillis()+60*60*24*10*1000);//缓存10天

		// 3.放行
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
