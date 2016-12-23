package com.demo.servletpath.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by 7 on 2016/12/22.
 * 当提交方法是get的时候，会出现乱码。
 */
@WebFilter(filterName = "FilterEncoding")
public class FilterEncoding implements Filter {

	private String encode;

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chan) throws ServletException, IOException {
//		System.out.println("FilterEncoding is running");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;


		request.setCharacterEncoding(encode);
		chan.doFilter(request, response);

//		HttpServletRequest myRequest = new MyRequest(request);
//		response.setContentType("text/html;charset=utf-8");
//		chan.doFilter(myRequest, response);
	}

	public void init(FilterConfig config) throws ServletException {
		encode = config.getInitParameter("encoding");
	}

}

class MyRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}


	// 重写关于获取请求参数的方法.
	@Override
	public String getParameter(String name) {
		Map<String, String[]> map = getParameterMap();

		if (name == null) {
			return null;
		}
		String[] st = map.get(name);
		if (st == null || st.length == 0) {
			return null;
		}

		return st[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();

		if (name == null) {
			return null;
		}
		String[] st = map.get(name);

		return st;

	}

	private boolean flag = true;

	@Override
	public Map getParameterMap() {
		// 1.得到所有请求参数的Map集合
		Map<String, String[]> map = request.getParameterMap(); // 有编码问题.

		// 2.解决编码问题.
		if (flag) {
			for (String key : map.keySet()) {
				String[] values = map.get(key);

				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("iso8859-1"), "utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

			}
			flag = false;
		}
		return map;
	}
}