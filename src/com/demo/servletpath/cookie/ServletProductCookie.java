package com.demo.servletpath.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 7 on 2016/11/29.
 */
@WebServlet(name = "ServletProductCookie")
public class ServletProductCookie extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cookieName = "product";
		response.setContentType("text/html;charset=UTF-8");
		//1.获取请求参数
		//2.获取cookie数组
		//3.如果cookie为null.那就是第一次访问创建cookie
		//4.判断cookie不是为null,
		//  如果为空，不用处理
		//如果不为空，追加上去
		//5.重定向到商品页面
		String id = request.getParameter("id");

		Cookie[] cookies = request.getCookies();

		Cookie cookieByName = MyCookieUtil.getCookieByName(cookies, cookieName);
		if (cookieByName == null) {
			Cookie cookie = new Cookie(cookieName, "");
			cookie.setMaxAge(7 * 24 * 60 * 60);
			cookie.setPath("/");
			//回写到浏览器
			response.addCookie(cookie);
		} else {
			boolean checkId = checkId(cookieByName, id);
			if (!checkId) {
				String value = cookieByName.getValue();
				cookieByName.setValue(value + "x" + id);
				cookieByName.setMaxAge(7 * 24 * 60 * 60);
				cookieByName.setPath("/");
				response.addCookie(cookieByName);
			}
		}
		response.sendRedirect("/ServletMirror/jsp/productcookie.jsp");
	}

	/**
	 * 到cookie中查找id
	 *
	 * @param cookieByName
	 * @param id
	 * @return get boolean
	 */
	private boolean checkId(Cookie cookieByName, String id) {
		String value = cookieByName.getValue();
		String[] split = value.split("x");
		for (String str : split) {
			if (str.equals(id)) {
				return true;
			}
		}
		return false;
	}
}
