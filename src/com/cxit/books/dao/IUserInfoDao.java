package com.cxit.books.dao;

import java.util.List;
import java.util.Map;

import com.cxit.books.model.UserInfo;

/**
 * 用户数据库访问层接口
 * @author 钟森阳
 *
 */
public interface IUserInfoDao {
	//接口得方法签名 和mapper配置节点的id同名
	public List<UserInfo> getAllUsers();
	//添加用户
	public int addUser(UserInfo u);
	//修改用户
	public int updateUser(UserInfo u);
	//删除用户
	public int deleteUser(String name);
	//查找用户
	public UserInfo findUser(String name);
	public UserInfo findUser2(Map<String, String> map);
}
