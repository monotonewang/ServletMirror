package com.demo.servletpath.jsptl;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 类似<c:if>标签，带有属性的
 * @author Administrator
 *
 */
public class TagDemo3 extends SimpleTagSupport{
	
	private boolean test;
	
	public void setTest(boolean test) {
		this.test = test;
	}
	
	public void doTag() throws JspException, IOException {
		if(test){
			getJspBody().invoke(null);
		}
	}
	
}
