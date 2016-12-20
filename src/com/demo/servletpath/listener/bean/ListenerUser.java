package com.demo.servletpath.listener.bean;

import com.sun.org.apache.xml.internal.serializer.utils.SerializerMessages_zh_CN;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * Created by 7 on 2016/12/20.
 */
public class ListenerUser implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable {
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

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("javaBean Binding");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("javaBean UnBinding");
	}

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("javaBean活化UnBinding");
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("javaBean钝化UnBinding");
    }
}
