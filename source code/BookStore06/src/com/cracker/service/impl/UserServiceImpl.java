package com.cracker.service.impl;

import com.cracker.bean.User;
import com.cracker.dao.UserDao;
import com.cracker.dao.impl.UserDaoImpl;
import com.cracker.service.UserService;

/**
 * UserService的实现类
 * @author
 *
 */
public class UserServiceImpl implements UserService {
	
	//创建一个UserDao对象
	private UserDao ud = new UserDaoImpl();

	@Override
	public User login(User user) {
		return ud.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		return ud.registUser(user);
	}

}
