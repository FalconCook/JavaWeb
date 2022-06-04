package com.cracker.dao.impl;

import com.cracker.bean.User;
import com.cracker.dao.BaseDao;
import com.cracker.dao.UserDao;

/**
 * UserDao的实现类
 * @author 
 *
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(User user) {
		
		String sql = "SELECT id , username , password , email FROM bs_user WHERE username=? AND password=?";
		
		return this.getBean(sql, user.getUsername() , user.getPassword());
	}

	@Override
	public boolean registUser(User user) {
		String sql = "INSERT INTO bs_user (username , password , email) VALUES(?,?,?)";
		int update =  this.update(sql, user.getUsername() , user.getPassword() , user.getEmail());
		return update>0;
	}

}
