package com.cracker.test;

import org.junit.Test;

import com.cracker.bean.User;
import com.cracker.dao.UserDao;
import com.cracker.dao.impl.UserDaoImpl;

public class UserDaoTest {
	
	UserDao ud = new UserDaoImpl();

	@Test
	public void test() {
		User user = new User(null, "tomcat", "123456", null);
		User loginUser = ud.getUserByUsernameAndPassword(user);
		System.out.println(loginUser);
	}

	@Test
	public void test2() {
		UserDao ud = new UserDaoImpl();
		boolean b = ud.registUser(new User(null, "tomcat2", "123456", null));
		System.out.println(b);
	}

}
