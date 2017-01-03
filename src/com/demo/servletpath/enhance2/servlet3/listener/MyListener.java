package com.demo.servletpath.enhance2.servlet3.listener; /**
 * Created by 7 on 2017/1/3.
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class MyListener implements ServletContextListener {

	// Public constructor is required by servlet spec
	public MyListener() {
	}

	// -------------------------------------------------------
	// ServletContextListener implementation
	// -------------------------------------------------------
	public void contextInitialized(ServletContextEvent sce) {
	  /* This method is called when the servlet context is
		 initialized(when the Web application is deployed).
         You can initialize servlet context related data here.
      */
//		System.out.println("this is my servlet3.0 listener ");
	}

	public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
	}


}
