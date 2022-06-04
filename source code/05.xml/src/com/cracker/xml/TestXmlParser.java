package com.cracker.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.cracker.xml.bean.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestXmlParser {
	
	@Test
    public void testXml1() throws DocumentException {
        // 1、导入dom解析包，dom4j-1.6
        // 2、创建一个SAXReader，一个xml文档阅读器
        SAXReader reader = new SAXReader();
        // 3 、使用reader读取文件即可，返回一个document对象
        Document document = reader.read(new File("stu.xml"));
        System.out.println(document);

        // 4、获取到document后，可以进行增删改查
	}
	
    @Test
    public void testXml2() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("stu.xml"));
        //解析
        /*short nodeType = document.getNodeType();
        System.out.println("nodeType = " + nodeType);*/

        // 4、先要获取根节点，使用根节点往下找
        // getNodeType()获取当前节点类型
        // getName()获取节点名字
        Element element = document.getRootElement();
        //System.out.println("跟标签的文本值： " + element.getText());

        // 5、使用根节点往下查找
        // 获取当前节点下的所有子节点
        List<Element> elements = element.elements();
        for (Element ele : elements) {
            // elementText(name)获取当前节点下名为name子元素的文本值
            //String text = ele.elementText("name");
            //System.out.println(text);

            List<Element> stuChild = ele.elements();
            for (Element ele2 : stuChild) {
                //System.out.println(ele2.getName());
                //getText()获取本标签里面的文本值
                System.out.println(ele2.getText());
            }
        }

        // elements代表所有student的集合
        for (Element eleTemp : elements) {
            //每个eleTemp代表一个student标签
            String id = eleTemp.attributeValue("id");
            System.out.println("id值：" + id);

        }
    }

    @Test
    public void testXml3() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("stu.xml"));

        Element rootEle = document.getRootElement();

        List<Element> elements = rootEle.elements();
        List<Student> list = new ArrayList<>();
        for (Element ele : elements) {
            String id = ele.attributeValue("id");
            String name = ele.elementText("name");
            String age = ele.elementText("age");
            list.add(new Student(name, Integer.parseInt(age), id));
        }
        System.out.println("list = " + list);

    }

    private String path = "/Users/chen/Downloads/";
    @Test
    public void testXml4() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("stu.xml"));
        
        //3、获取根节点
        Element rootElement = document.getRootElement();
        //获取到的是第一个student
        Element element = rootElement.element("student");
        Element name = element.element("name");
        System.out.println(name.getText());
        name.setText("张三3");
        name.addAttribute("firstName", "张");

        //4、修改的东西保存起来
        //OutputFormat将输出的数据格式化（看起来整齐）
        //OutputFormat format = OutputFormat.createCompactFormat();
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileOutputStream("out.xml"), format);
        writer.write(document);
        writer.close();

    }

    /**
     * 测试xPath
     * xPath 是用来简化dom查找
     * xPath	/ 从根开始找
     * 			//找所有
     * @throws Exception 
     */
    @Test
    public void testXml5() throws Exception {
    	SAXReader reader = new SAXReader();
        Document document = reader.read("stu.xml");
        Element rootElement = document.getRootElement();
        
        //用id获取 student id=456
        Node node = rootElement.selectSingleNode("//student[@id='123']");
        Element ele = (Element) node;
        String id = ele.attributeValue("id");
        System.out.println(id);
        
        //获取到所有的name标签
        List<Element> list = rootElement.selectNodes("//name");
        for (Element element : list) {
        	String text = element.getText();
            System.out.println(text);
		}
    }
}