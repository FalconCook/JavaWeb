package com.cracker.listener.session;

import java.io.Serializable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听student对象的钝化和活化
 * @author chen
 * 对象要和session一起活化钝化必须实现序列化接口
 * 不需要web.xml里配置
 */
public class Student implements HttpSessionActivationListener, Serializable{

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	public Student() {
		super();
	}

	public Student(String username) {
		super();
		this.username = username;
	}

	@Override
	public String toString() {
		return "Student [username=" + username + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("我和session要一起钝化了...");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("我和session要一起活化了...");
		HttpSession session = se.getSession();
		Object attribute = session.getAttribute("user");
		System.out.println(attribute);
	}

}
