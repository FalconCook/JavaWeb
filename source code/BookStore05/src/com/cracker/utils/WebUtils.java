package com.cracker.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	public static<T> T param2bean(HttpServletRequest request, T t) {
		//封装对象，返回
		//1、获取所有声明的属性
		Field[] fields = t.getClass().getDeclaredFields();
		
		//2、每个属性都有name值，属性名
		for (Field field : fields) {
			//获取属性名
			String name = field.getName();
			//在request中获取相应的属性值
			String value = request.getParameter(name);
			try {
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	
	public static<T> T param2bean2(HttpServletRequest request, T t) {
		//populate将map中的键值对，直接映射到javaBean中
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
