package com.cracker.listener.session;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{

	private String username;
	
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}

	public User() {
		super();
	}

	public User(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//User类对象绑定到session中
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("对象绑定到session中了......");
		System.out.println("对象绑定在session中使用的key："+event.getName());
		System.out.println("对象绑定在session中的具体对象："+event.getValue());
	}

	//User类对象从session中移除
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("对象从session中解除绑定了......");
		System.out.println("session中解除对象使用的key："+event.getName());
		System.out.println("session中解除的具体对象："+event.getValue());
	}

}
