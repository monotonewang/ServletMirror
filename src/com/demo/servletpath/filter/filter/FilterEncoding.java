package com.demo.servletpath.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/22.
 */
@WebFilter(filterName = "FilterEncoding")
public class FilterEncoding implements Filter {

	private String encode;

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chan) throws ServletException, IOException {
		System.out.println("FilterEncoding is running");
		HttpServletRequest httpServletRequest= (HttpServletRequest) req;
		HttpServletResponse httpServletResponse= (HttpServletResponse) resp;
		httpServletRequest.setCharacterEncoding(encode);
		chan.doFilter(req, resp);
	}

	public void init(FilterConfig config) throws ServletException {
		encode = config.getInitParameter("encoding");
	}

}
