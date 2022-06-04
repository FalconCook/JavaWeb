package com.cracker.listener.attribute;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * 监听request域中属性变化
 * @author chen
 *
 */
public class RequestAttributeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request域中增加属性......");
		//增加的属性名、值
		System.out.println(srae.getName()+"-->"+srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request域中移除属性......");
		// 移除的属性名、值
		System.out.println(srae.getName()+"-->"+srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request域中替换属性......");
		// 替换的属性名、值
		String name = srae.getName();
		System.out.println(name+"修改前的值"+srae.getValue());
		ServletRequest request = srae.getServletRequest();
		Object attribute = request.getAttribute(name);
		System.out.println(name+"修改后的值"+attribute);
	}

}
