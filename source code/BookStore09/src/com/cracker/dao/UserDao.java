package com.cracker.dao;

import com.cracker.bean.User;

public interface UserDao{
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	public User getUserByUsernameAndPassword(User user);
	
	/**
	 * 向数据库中插入一个用户对象
	 * @param user
	 * @return
	 */
	public boolean registUser(User user);
	
	public User getUserByUserName(User user);
	
}
