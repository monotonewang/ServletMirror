package com.demo.servletpath.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//book2.xml path
//Document document = builder.parse("src/com/demo/servletpath/xml/book/book2.xml");
/**
 * JAXP的DOM解析XML
 * @author Administrator
 *
 */
public class JaxpDomTest {
	
	public static void main(String[] args) {
		try {
			run1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取作者的文本内容
	 * @throws Exception 
	 */
	public static void run1() throws Exception{
		// 获取解析器工厂类
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 获取解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 解析XML的文档，返回document对象
//		Document document = builder.parse("src/book2.xml");
		Document document = builder.parse("src/com/demo/servletpath/xml/book/book2.xml");
		// 获取作者元素对象的集合，返回NodeList
		NodeList nodeList = document.getElementsByTagName("作者");
		// 循环遍历，拿到每一个作者，打印文本的内容，getTextContent()
		for(int i=0;i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			System.out.println(node.getTextContent());
		}
	}
	
	
	/**
	 * 需求：在第二本下，在末尾添加子节点
	 * @throws Exception
	 */
	public static void run2() throws Exception{
		// 获取工厂类
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 获取解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 解析xml，返回document对象
		Document document = builder.parse("src/book2.xml");
		// 获取第二本书
		Node book2 = document.getElementsByTagName("书").item(1);
		// 创建元素对象
		Element cat = document.createElement("猫");
		// 设置文本内容
		cat.setTextContent("我是猫");
		// 把元素对象添加到第二本书下
		book2.appendChild(cat);
		// 回写
		// 创建回写类的工厂
		TransformerFactory transformerFactory =  TransformerFactory.newInstance();
		// 获取回写类
		Transformer transformer = transformerFactory.newTransformer();
		// 调用回写的方法
		transformer.transform(new DOMSource(document), new StreamResult("src/book2.xml"));
	}
	
	/**
	 * 删除节点
	 * @throws Exception 
	 */
	public static void run3() throws Exception{
		String path = "src/book2.xml";
		// 获取文档对象
		Document document = JaxpDomUtil.getDocument(path);
		// 获取猫
		Node cat = document.getElementsByTagName("猫").item(0);
		// 获取书（猫的父节点）
		Node book2 = cat.getParentNode();
		// 通过书删除猫
		book2.removeChild(cat);
		// 回写
		JaxpDomUtil.writeXML(document, path);
	}
	
}







