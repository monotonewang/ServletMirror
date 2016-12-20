package com.demo.servletpath.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/12/14.
 */
@WebFilter(filterName = "MyFilter")
//@WebFilter(filterName = "MyFilter",urlPatterns={"index.jsp"} )
//initParams={@WebInitParam(name="count",value="5000")}
public class MyFilter implements Filter {
	int count = 200;
	private ServletContext servletContext;

	/**
	 * when start server call this method
	 * @param config
	 * @throws ServletException
	 */
	public void init(FilterConfig config) throws ServletException {
		//获取Filter 名称
		String filterName = config.getFilterName();
//		System.out.println("filterName"+filterName);

		//获取初始化参数
		String encoding = config.getInitParameter("encoding");
//		System.out.println("encoding"+encoding);
		String username = config.getInitParameter("username");
//		System.out.println("username"+username);

		//get servletContext
		//获取全局对象
		servletContext = config.getServletContext();
	}

	/**
	 *  when call filter-mapping page call this method
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//		System.out.println("firstFilter.......");
		chain.doFilter(req, resp);//向下放行
//		System.out.println("firstFilter end.....");
		count++;
		HttpServletResponse response = (HttpServletResponse) resp;
//		response.getWriter().write("count=" + count);
	}

	/**
	 * when stop server call this method
	 */
	public void destroy() {
//		System.out.println("MyFilter-->destroy");
	}

}
