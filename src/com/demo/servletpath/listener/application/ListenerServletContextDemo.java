package com.demo.servletpath.listener.application;
/**
 * Created by 7 on 2016/12/20.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ListenerServletContextDemo implements ServletContextListener {

	// Public constructor is required by servlet spec
	public ListenerServletContextDemo() {
	}

	// -------------------------------------------------------
	// ServletContextListener implementation
	// -------------------------------------------------------
	public void contextInitialized(ServletContextEvent sce) {
	  /* This method is called when the servlet context is
		 initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
//		System.out.println("servletContext对象创建");
	}

	public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
//		System.out.println("servletContext对象销毁");
	}

}
