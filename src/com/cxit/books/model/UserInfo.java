package com.cxit.books.model;

public class UserInfo {
    //�û���
	private String userName;
    //����
	private String passWord;
    //�����ַ 
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
