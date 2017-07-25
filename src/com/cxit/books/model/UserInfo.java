package com.cxit.books.model;

public class UserInfo {
    //用户名
	private String userName;
    //密码
	private String passWord;
    //邮箱地址 
	private String email;
	public UserInfo() {
	}
	public UserInfo(String userName, String passWord, String email) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", passWord=" + passWord
				+ ", email=" + email + "]";
	}
	

}
