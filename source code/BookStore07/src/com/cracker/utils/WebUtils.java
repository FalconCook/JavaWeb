package com.cracker.utils;

import java.lang.reflect.Field;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.cracker.bean.Cart;
import com.cracker.bean.User;

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
		Map<?, ?> map = request.getParameterMap();
		try {
			BeanUtils.populate(t, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	public static Cart getCart(HttpServletRequest request) {
		//购物车的整个内容 Cart 在session中保存
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			//给session中放入购物车
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	public static User getLoginUser(HttpServletRequest request) {
		//1、验证用户是否登陆
		HttpSession session = request.getSession();
		return (User) session.getAttribute("user");
		
	}
}
