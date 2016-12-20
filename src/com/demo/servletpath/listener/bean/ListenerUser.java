package com.demo.servletpath.listener.bean;

import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by 7 on 2016/12/20.
 */
public class ListenerUser implements HttpSessionBindingListener {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
