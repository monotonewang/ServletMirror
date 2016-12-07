package com.demo.servletpath.jsptl;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 带有标签主体
 * @author Administrator
 *
 */
public class TagDemo2 extends SimpleTagSupport{
	
	private PageContext pc;
	
	public void doTag() throws JspException, IOException {
		JspFragment jf = getJspBody();
		jf.invoke(null);
	}
	
	public void setJspContext(JspContext pc) {
		this.pc = (PageContext)pc;
	}
}
