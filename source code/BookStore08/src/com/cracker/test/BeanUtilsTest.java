package com.cracker.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.cracker.bean.User;

public class BeanUtilsTest {
	
	@Test
	public void test1() {
		//bean代表个给哪个对象设置属性值
		//name代表要设置的属性名
		//value要设置的值
		User user = new User();
		System.out.println("未设置之前："+user);
		try {
			BeanUtils.setProperty(user, "username", "小明");
			System.out.println("设置之后："+user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		Student student = new Student();
		System.out.println("设置之前"+student);
		try {
			BeanUtils.setProperty(student, "age", 12);
			System.out.println("设置之后"+student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//get、set方法才是bean的属性，setAttr-->attr
	}
}
