package com.cracker.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestI18N {
	
	@Test
	public void test1() {
		
		//获取默认区域信息
		Locale locale = Locale.getDefault();
		//System.out.println(locale);
		Locale us = Locale.US;
		Locale cn = Locale.CHINA;	
		
		DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, us);
		String format = dateInstance.format(new Date());
		System.out.println(format);
	}
	
	@Test
	public void test2() {
		//国际化资源文件，保存不同的语言信息，由ResourceBundle来管理
		//.properties 文件名：基础名_语言_国家.properties
		//如果是中国 i18n_zh_CN.properties
		//将要显示的信息放在这些文件中，然后通过文件动态获取。这些文件放在类路径下（src）
		
		Locale cn = Locale.CHINA;
		ResourceBundle bundle = ResourceBundle.getBundle("i18n", cn);
		String string = bundle.getString("login");
		System.out.println(string);
	}
}
