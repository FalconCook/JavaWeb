package com.cracker.bean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class OnlineUser implements HttpSessionAttributeListener,ServletContextListener{

	private static List<User> users;
	
	public static List<User> getUsers() {
		return users;
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("添加用户监听......"+se.getValue().toString());
		User user = (User) se.getValue();
		users.add(user);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext初始化......");
		users = new ArrayList<User>();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
