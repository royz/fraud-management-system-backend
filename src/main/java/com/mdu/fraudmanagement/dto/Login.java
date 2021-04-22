package com.mdu.fraudmanagement.dto;

public class Login {
	
	private String userId;
	private String password;
	
	
	
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Login(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Login [userId=" + userId + ", password=" + password + "]";
	}
	
	
	
	

}
