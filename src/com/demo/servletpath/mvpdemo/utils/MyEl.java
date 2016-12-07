package com.demo.servletpath.mvpdemo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class MyEl {
	// %E9%83%AD%E7%BE%8E%E7%BE%8E
	public static String myDecode(String str){
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
