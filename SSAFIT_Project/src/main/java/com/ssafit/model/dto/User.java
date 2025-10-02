package com.ssafit.model.dto;

public class User {

	private int userId;
	private String userEmail;
	private String userPassword;
	private String userNickname;


	public User() {
	}

	public User(String userEmail, String userPassword, String userNickname) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
	}
	public User(int userId, String userEmail, String userPassword, String userNickname) {
	    this.userId = userId;
	    this.userEmail = userEmail;
	    this.userPassword = userPassword;
	    this.userNickname = userNickname;
	}

	public User(String userEmail, String userPassword) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userNickname=" + userNickname + "]";
	}
}
