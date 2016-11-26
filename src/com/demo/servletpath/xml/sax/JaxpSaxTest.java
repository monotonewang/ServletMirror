package com.demo.servletpath.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * SAX的入门
 * @author Administrator
 *
 */
public class JaxpSaxTest {
	
	public static void main(String[] args) {
		try {
			run1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取所有的解析的内容
	 * @throws Exception 
	 * @throws ParserConfigurationException 
	 */
	public static void run1() throws Exception{
		// 获取SAX的解析器工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 获取解析器
		SAXParser parser =  factory.newSAXParser();
		// 解析
		parser.parse("src/book2.xml", new MyHandler());
//		parser.parse("src/book2.xml", new MyHandler2());
	}
}


/**
 * 获取作者标签的文本内容
 * 	
 */
class MyHandler2 extends DefaultHandler{
	// 如果解析到作者标签的时候，flag设置成true
	private boolean flag = false;
	private int count = 0;
	
	/**
	 * 默认解析开始标签，默认调用该方法
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// 如果要是作者标签，flag设置成true
		if("作者".equals(qName)){
			flag = true;
			count++;
		}
	}

	/**
	 * 能控制characters的输出，我只在解析作者标签的时候，才打印
	 */
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// 如果flag是true，就打印
		// 每一次都打印
		if(flag && count == 1){
			String str = new String(ch,start,length);
			System.out.println(str);
		}
	}
	
	/**
	 * 
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// flag恢复成false
		flag = false;
	}
}


/**
 * 自己事件处理器
 * 重写三方法
 * @author Administrator
 *
 */
class MyHandler extends DefaultHandler{
	
	/**
	 * 只要一解析到开始标签的时候，默认调用该方法，把解析的内容赋值给参数。
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("开始标签："+qName);
	}
	
	/**
	 * 只要解析到文本的内容，默认调用该方法
	 */
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str = new String(ch,start,length);
		System.out.println(str);
	}

	/**
	 * 解析到结束标签的时候，默认调用方法，把解析的内容赋值给参数。
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("结束标签："+qName);
	}
	
}




