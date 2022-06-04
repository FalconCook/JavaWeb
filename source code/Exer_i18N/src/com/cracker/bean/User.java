package com.cracker.bean;

public class User {
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User(String username) {
		super();
		this.username = username;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
	
}
