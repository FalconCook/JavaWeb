package com.cracker.service;

import com.cracker.bean.User;

/**
 * 完成登录注册
 * @author
 *
 */
public interface UserService {
	User login(User user);
	boolean regist(User user);
}
