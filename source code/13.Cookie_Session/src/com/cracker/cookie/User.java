package com.cracker.cookie;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	
	
}
