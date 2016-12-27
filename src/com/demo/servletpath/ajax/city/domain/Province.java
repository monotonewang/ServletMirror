package com.demo.servletpath.ajax.city.domain;

import java.util.List;

/**
 * Created by 7 on 2016/12/27.
 */
public class Province {
	private String name;
	private List<City> citys;

	public Province(String name, List<City> citys) {
		this.name = name;
		this.citys = citys;
	}

	public Province() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
}
