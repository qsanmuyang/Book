package com.cxit.books.biz;

import java.util.List;

import com.cxit.books.model.UserInfo;

/**
 * 用户信息业务接口
 * @author 钟森阳
 *
 */
public interface IUserInfoBiz {
	//登录方法
	public boolean login(UserInfo u);
	//用户注册
	public int regist(UserInfo u);
	//通过用户名删除用户
	public int delUserByUserName(String name);
	//获取所有用户集合
	public List<UserInfo> getAllUsers();
	//通过用户名查找用户是否存在
	public boolean findUser(String name);
}
