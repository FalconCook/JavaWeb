package com.cracker.listener.lifecycle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationLifeListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext初始化......");
		//1、sce可以获取到当前web应用的ServletContext对象
		ServletContext servletContext = sce.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext销毁......");
	}

}
