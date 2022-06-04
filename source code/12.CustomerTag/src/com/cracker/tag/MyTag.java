 package com.cracker.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyTag implements SimpleTag {
	
	private String msg;
	private PageContext pc;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
		System.out.println("接受到的属性值："+msg);
	}

	/**
	 * 执行标签功能
	 */
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag()......");
		pc.getOut().write("<h1>"+msg+"</h1>");
	}

	/**
	 * 获取父标签(只特指自定义标签)
	 */
	@Override
	public JspTag getParent() {
		System.out.println("getParent()......");
		return null;
	}

	/**
	 * 设置JspBody标签体内容
	 */
	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspContext()......");
		System.out.print(arg0);
	}

	/**
	 * 设置JspContext	==	pageContext 服务器自动传入
	 */
	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println("setJspContext()......");
		this.pc = (PageContext)arg0;
		System.out.println(arg0);
	}

	/**
	 * 设置父标签 服务器自动传进来
	 */
	@Override
	public void setParent(JspTag arg0) {
		System.out.println("getParent()......");
	}

}
