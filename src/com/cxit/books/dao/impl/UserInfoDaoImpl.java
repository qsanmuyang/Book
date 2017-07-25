package com.cxit.books.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cxit.books.dao.IUserInfoDao;
import com.cxit.books.model.UserInfo;
import com.cxit.books.util.BaseDao;

/**
 * ���ݿ�ʵ���಻��Ҫȥǿ��ʵ�����ݿ�ӿ�
 * @author ��ɭ��
 *
 */
@Repository
public class UserInfoDaoImpl extends BaseDao {
	/**
	 * ���������û�
	 * @return
	 */
	public List<UserInfo> getUserInfos(){
		List<UserInfo> userList = new ArrayList<UserInfo>();
		IUserInfoDao userInfoDao=null;
		SqlSession session=null;
		try {
			//���ӳ���ļ�
			session=openSession();
			userInfoDao=session.getMapper(IUserInfoDao.class);
			    //ִ��ӳ���ļ���id��sql���
			userList=userInfoDao.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			userList=null;
		}finally{
			session.close();
			userInfoDao=null;
		}
		return userList;
	}
	
	public int addUserInfo(UserInfo userInfo){
		int result=0;
		IUserInfoDao userInfoDao=null;
		SqlSession session=null;
		try {
			session=openSession();
			userInfoDao=session.getMapper(IUserInfoDao.class);
			result=userInfoDao.addUser(userInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			userInfoDao=null;
		}
		return result;
	}
	public int updateUserInfo(UserInfo userInfo){
		int result=0;
		IUserInfoDao userInfoDao=null;
		SqlSession session=null;
		try {
			session=openSession();
			userInfoDao=session.getMapper(IUserInfoDao.class);
			result=userInfoDao.updateUser(userInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			userInfoDao=null;
		}
		return result;
	}
	public int deleteUserInfo(String name){
		int result=0;
		IUserInfoDao userInfoDao=null;
		SqlSession session=null;
		try {
			session=openSession();
			userInfoDao=session.getMapper(IUserInfoDao.class);
			result=userInfoDao.deleteUser(name);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			userInfoDao=null;
		}
		return result;
	}
	public UserInfo getUserByName(String name){
		UserInfo uInfo=null;
		IUserInfoDao userInfoDao=null;
		SqlSession session=null;
		try {
			session=openSession();
			userInfoDao=session.getMapper(IUserInfoDao.class);
			uInfo=userInfoDao.findUser(name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			userInfoDao=null;
		}
		return uInfo;
	}
	public UserInfo findUser(Map map){
		UserInfo uInfo=null;
		IUserInfoDao userInfoDao=null;
		SqlSession session=null;
		try {
			session=openSession();
			userInfoDao=session.getMapper(IUserInfoDao.class);
			uInfo=userInfoDao.findUser2(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			userInfoDao=null;
		}
		return uInfo;
	}
}
