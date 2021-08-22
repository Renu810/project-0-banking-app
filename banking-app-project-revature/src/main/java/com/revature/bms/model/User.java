package com.revature.bms.model;

import java.io.Serializable;

public class User implements Serializable{

	
	private int userId;
	private String userName;
	private int password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(String userName, int password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public User(int userId, String userName, int password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getPassword() {
		return password;
	}


	public void setPassword(int password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "\nUser [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
