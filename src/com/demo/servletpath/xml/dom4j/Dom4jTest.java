package com.demo.servletpath.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

/**
 * DOM4J的解析XML
 *
 * @author Administrator
 */
public class Dom4jTest {

    public static void main(String[] args) {
        try {
            run6();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对XPATH的支持
     *
     * @throws Exception
     */
    public static void run6() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // List<Node> list = document.selectNodes("/书架/书/作者");
        List<Node> list = document.selectNodes("//作者");
        Node author2 = list.get(1);
        System.out.println(author2.getText());
    }

    /**
     * 修改文本内容
     *
     * @throws Exception
     */
    public static void run5() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取狗的节点
        Element book2 = (Element) root.elements("书").get(1);
        Element dog = book2.element("狗");
        dog.setText("小狗");
        // 回写
        // 回写
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 回写
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        writer.write(document);
        writer.close();
    }

    /**
     * 删除子节点
     * 删除第二本书下的猫节点
     */
    public static void run4() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取猫
        Element book2 = (Element) root.elements("书").get(1);
        Element cat = book2.element("猫");
        // 通过猫获取猫的父节点
        // cat.getParent();
        // 通过父节点删除猫
        book2.remove(cat);
        // 回写
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 回写
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        writer.write(document);
        writer.close();
    }

    /**
     * 在第二本书的作者标签之前添加团购价的标签
     *
     * @throws Exception
     */
    public static void run3() throws Exception {
        // List
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取第二本书
        Element book2 = (Element) root.elements("书").get(1);
        // 获取书下的所有子节点，返回List集合
        List<Element> list = book2.elements();
        // 创建元素对象	DocumentHelper.createElement("狗")
        Element dog = DocumentHelper.createElement("狗");
        dog.setText("大狗");
        // list.add(index,Element);
        list.add(1, dog);

        OutputFormat format = OutputFormat.createPrettyPrint();
        // 回写
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        writer.write(document);
        writer.close();
    }


    /**
     * 在第二本书下添加子节点
     */
    public static void run2() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML，返回Document对象
        Document document = reader.read("src/book2.xml");
        // 获取根节点
        Element root = document.getRootElement();
        // 获取第二本书
        Element book2 = (Element) root.elements("书").get(1);
        // 可以直接在第二本书下添加子节点，设置文本内容
        book2.addElement("猫").setText("我是猫");
        // 回写

        // 创建漂亮的格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        //OutputFormat format = OutputFormat.createCompactFormat();

        // 设置编码
        format.setEncoding("UTF-8");

        // 回写类
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"), format);
        // 回写了文档对象
        writer.write(document);
        // 关闭流
        writer.close();
    }

    /**
     * 获取第二本书作者的文本内容
     *
     * @throws Exception
     */
    public static void run1() throws Exception {
        // 获取解析器对象
        SAXReader reader = new SAXReader();
        // 解析XML，返回Document对象
        Document document = reader.read("src/book2.xml");
        // 获取根节点（书架标签）
        Element root = document.getRootElement();
        // 获取书的节点，获取第二本书
        List<Element> books = root.elements("书");
        Element book2 = books.get(1);
        // 获取作者的标签
        Element author2 = book2.element("作者");
        // 获取文本内容
        System.out.println(author2.getText());
    }

}








