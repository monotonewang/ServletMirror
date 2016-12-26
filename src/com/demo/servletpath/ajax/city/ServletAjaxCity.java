package com.demo.servletpath.ajax.city;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by 7 on 2016/12/26.
 */
@WebServlet(name = "ServletAjaxCity")
public class ServletAjaxCity extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HashMap<String, String[]> map = new HashMap<>();
		map.put("广东省", new String[]{"深圳市", "湛江市", "中山市"});
		map.put("江西省", new String[]{"赣州市", "上饶市", "南昌市"});
		map.put("福建省", new String[]{"泉州市", "厦门市", "福州市"});
		map.put("浙江省", new String[]{"温州市", "杭州市", "衢州市"});
		map.put("江苏省", new String[]{"苏州市", "无锡市", "镇江市"});
		Gson gson = new Gson();
		String json = gson.toJson(map);
		out.write(json);
	}
}
