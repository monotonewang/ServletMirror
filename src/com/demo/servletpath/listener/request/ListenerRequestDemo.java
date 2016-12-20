package com.demo.servletpath.listener.request; /**
 * Created by 7 on 2016/12/20.
 */

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * auto call method
 */
@WebListener()
public class ListenerRequestDemo implements ServletRequestListener {

	// Public constructor is required by servlet spec
	public ListenerRequestDemo() {
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
//		System.out.println("request对象创建");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
//		System.out.println("request对象销毁");
	}
}
