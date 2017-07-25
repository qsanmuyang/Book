package com.cxit.books.dao;

import java.util.List;
import java.util.Map;

import com.cxit.books.model.UserInfo;

/**
 * �û����ݿ���ʲ�ӿ�
 * @author ��ɭ��
 *
 */
public interface IUserInfoDao {
	//�ӿڵ÷���ǩ�� ��mapper���ýڵ��idͬ��
	public List<UserInfo> getAllUsers();
	//����û�
	public int addUser(UserInfo u);
	//�޸��û�
	public int updateUser(UserInfo u);
	//ɾ���û�
	public int deleteUser(String name);
	//�����û�
	public UserInfo findUser(String name);
	public UserInfo findUser2(Map<String, String> map);
}
