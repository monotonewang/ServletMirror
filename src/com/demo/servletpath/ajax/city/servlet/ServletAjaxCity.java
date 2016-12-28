package com.demo.servletpath.ajax.city.servlet;

import com.demo.servletpath.ajax.city.domain.City;
import com.demo.servletpath.ajax.city.domain.Province;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		List<Province> provinces = new ArrayList<>();

		List<City> list0 = new ArrayList<>();
		list0.add(new City("深圳市"));
		list0.add(new City("湛江市"));
		list0.add(new City("中山市"));
		provinces.add(new Province("广东省", list0));
		List<City> list1 = new ArrayList<>();
		list1.add(new City("赣州市"));
		list1.add(new City("上饶市"));
		list1.add(new City("南昌市"));
		provinces.add(new Province("江西省", list1));
		List<City> list2 = new ArrayList<>();
		list2.add(new City("泉州市"));
		list2.add(new City("厦门市"));
		list2.add(new City("福州市"));
		provinces.add(new Province("福建省", list2));
		List<City> list3 = new ArrayList<>();
		list3.add(new City("温州市"));
		list3.add(new City("杭州市"));
		list3.add(new City("衢州市"));
		provinces.add(new Province("浙江省", list3));
		List<City> list4 = new ArrayList<>();
		list4.add(new City("苏州市"));
		list4.add(new City("无锡市"));
		list4.add(new City("镇江市"));
		provinces.add(new Province("江苏省", list4));
		Gson gson = new Gson();
		String json = gson.toJson(provinces);
		out.write(json);
	}

}
