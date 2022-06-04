package com.cracker.upload;

public class User {
	private String username;
	private String imgPath;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public User() {
		super();
	}
	public User(String username, String imgPath) {
		super();
		this.username = username;
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", imgPath=" + imgPath + "]";
	}
	
	
}
