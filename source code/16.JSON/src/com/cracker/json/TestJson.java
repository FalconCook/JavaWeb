package com.cracker.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * json字符串-->java对象之间的互转
 * @author chen
 *
 */
public class TestJson {
	
	/**
	 * 将对象转为json字符串
	 */
	@Test
	public void test() {
		Student student = new Student("张三", 20);
		//这是默认描述对象的字符串
		String string = student.toString();
		//在网络间传递原生字符串不好解析
		System.out.println(string);
		
		//
		Gson gson = new Gson();
		//把对象转成json字符串
		String json = gson.toJson(student);
		System.out.println(json);
	}
	
	@Test
	public void test2() {
		Student student = new Student("李四", 18);
		Gson gson = new Gson();
		//把对象转成json字符串
		String json = gson.toJson(student);
		
		Student student2 = gson.fromJson(json, Student.class);
		System.out.println(student2);
	}
	
	/**
	 * json字符串与list的互转
	 */
	@Test
	public void test3() {
		Student student1 = new Student("李四", 18);
		Student student2 = new Student("张三", 20);
		List<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		
		//将list转为json字符串
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println("list转为json:"+json);
		
		//gson TypeToken接口
		//调用继承TypeToken类对象的getType
		List<Student> fromJson = gson.fromJson(json, new MyType().getType());
		System.out.println("json字符串转为list："+fromJson);
	}
	
	/**
	 * json与map直接互转
	 */
	@Test
	public void test4() {
		Map<String, Student> map = new HashMap<>();
		Student student1 = new Student("李四", 18);
		Student student2 = new Student("张三", 20);
		map.put("no1", student1);
		map.put("no2", student2);
		
		Gson gson = new Gson();
		//将map转为json字符串
		String json = gson.toJson(map);
		System.out.println(json);
		
		Map<String, Student> fromJson = gson.fromJson(json, new TypeToken<Map<String, Student>>(){}.getType());
		System.out.println(fromJson);
		System.out.println(fromJson.get("no1").getName());	
	}
}
