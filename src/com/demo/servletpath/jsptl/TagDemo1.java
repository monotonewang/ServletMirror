package com.demo.servletpath.jsptl;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 对外输出Hello
 * @author Administrator
 *
 */
public class TagDemo1 extends SimpleTagSupport{
	
	private PageContext pc;
	
	public void doTag() throws JspException, IOException {
		pc.getOut().write("Hello");
	}
	
	/**
	 * 服务器默认先执行该方法
	 */
	public void setJspContext(JspContext pc) {
		this.pc = (PageContext) pc;
	}

}
