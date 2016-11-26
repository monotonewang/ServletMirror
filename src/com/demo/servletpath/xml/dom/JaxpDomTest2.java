package com.demo.servletpath.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * 作业
 * @author Administrator
 *
 */
public class JaxpDomTest2 {

	public static void main(String[] args) throws Exception {
		run1();
	}
	
	/**
	 * 获取第一本书的属性值
	 * @throws Exception
	 */
	public static void run2() throws Exception{
		// 获取工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 解析
		Document document = builder.parse("src/book2.xml");
		// 获取第一本书
		Node book1 = document.getElementsByTagName("书").item(0);
		// 向下转型
		Element book = (Element) book1;
		System.out.println(book.getAttribute("编号"));
	}
	
	/**
	 * 在作者标签之前，添加团购价标签
	 * @throws Exception 
	 */
	public static void run1() throws Exception{
		// 获取工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 解析
		Document document = builder.parse("src/book2.xml");
		// 获取作者.获取父节点
		Node author2 = document.getElementsByTagName("作者").item(1);
		Node book2 = author2.getParentNode();
		// 创建元素
		Element tgj = document.createElement("团购价");
		// 设置文本
		tgj.setTextContent("9两");
		// 加入到作者之前
		book2.insertBefore(tgj, author2);
		// 回写
		TransformerFactory factory2 = TransformerFactory.newInstance();
		Transformer transformer = factory2.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/book2.xml"));
	}

}

















