package com.demo.servletpath.cookie;

import javax.servlet.http.Cookie;

/**
 * cookie工具类
 * @author Administrator
 *
 */
public class MyCookieUtil {
	
	/**
	 * 通过指定名称查找指定的cookie
	 * @param cookies cookies
	 * @param name cookies name
	 * @return null
	 */
	public static Cookie getCookieByName(Cookie [] cookies,String name){
		// 如果数组是null
		if(cookies == null){
			System.out.println("cookies is null");
			return null;
		}else{
			// 循环遍历，目的：和name进行匹配，如果匹配成功，返回当前的cookie
			for (Cookie cookie : cookies) {
				// 获取cookie的名称，和name进行匹配
				if(cookie.getName().equals(name)){
					System.out.println("name="+cookie.getName());
					return cookie;
				}
			}
			return null;
		}
	}
	
}














