package com.demo.servletpath.listener.session; /**
 * Created by 7 on 2016/12/20.
 */

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class ListenerSession implements
		HttpSessionListener, HttpSessionAttributeListener {

	// Public constructor is required by servlet spec
	public ListenerSession() {
	}

	// -------------------------------------------------------
	// HttpSessionListener implementation
	// -------------------------------------------------------
	public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
//		System.out.println("session对象创建了");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
//		System.out.println("session对象销毁了");
	}

	// -------------------------------------------------------
	// HttpSessionAttributeListener implementation
	// -------------------------------------------------------

	public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
//        String sname = (String) sbe.getSession().getAttribute(sbe.getName());
//        System.out.println("sname="+sname);
//        System.out.println("session属性创建了");
	}

	public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
//		System.out.println("session属性销毁了");
	}

	public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
	}
}
