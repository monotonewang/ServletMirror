package com.demo.servletpath.enhance2.proxy.encoding;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 7 on 2017/1/4.
 */
//代理模式 编码
@WebFilter("/*")
public class FilterProxyEnconding implements Filter {

	public void init(FilterConfig config) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		//1.强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//2.操作
		//创建一个req对象的代理对象reqProxy
		Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 1.得到方法名称
				String methodName = method.getName();
				if ("getParameter".equals(methodName)) {
					String param = req.getParameter((String) (args[0]));

					return new String(param.getBytes("iso8859-1"), "utf-8");

				} else {
					// 不是getParameter方法，就执行其原来操作.
					return method.invoke(req, args);
				}
			}
		});

		//3.放行
		chain.doFilter(req, resp);
	}

	public void destroy() {

	}

}
