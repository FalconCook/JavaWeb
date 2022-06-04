package com.cracker.listener.lifecycle;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 1、实现接口
 * 2、在web.xml中配置
 * @author chen
 *
 */
public class RequestLifeListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request对象销毁......");
		//sre方法
		//1、获取servletContext
		//2、获取servletRequest

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request对象初始化......");
	}

}
