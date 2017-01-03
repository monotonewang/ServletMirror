package com.demo.servletpath.enhance2.servlet3.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by 7 on 2017/1/3.
 */
@WebFilter("/*")
public class MyFilter implements Filter{
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//		System.out.println("this is servlet 3.0 filter");
		filterChain.doFilter(servletRequest,servletResponse);
	}
}
