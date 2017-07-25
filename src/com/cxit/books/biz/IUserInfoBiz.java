package com.cxit.books.biz;

import java.util.List;

import com.cxit.books.model.UserInfo;

/**
 * �û���Ϣҵ��ӿ�
 * @author ��ɭ��
 *
 */
public interface IUserInfoBiz {
	//��¼����
	public boolean login(UserInfo u);
	//�û�ע��
	public int regist(UserInfo u);
	//ͨ���û���ɾ���û�
	public int delUserByUserName(String name);
	//��ȡ�����û�����
	public List<UserInfo> getAllUsers();
	//ͨ���û��������û��Ƿ����
	public boolean findUser(String name);
}
