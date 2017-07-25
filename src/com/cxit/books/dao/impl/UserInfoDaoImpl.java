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
 * 数据库实现类不需要去强制实现数据库接口
 * @author 钟森阳
 *
 */
@Repository
public class UserInfoDaoImpl extends BaseDao {
	/**
	 * 查找所有用户
	 * @return
	 */
	public List<UserInfo> getUserInfos(){
		List<UserInfo> userList = new ArrayList<UserInfo>();
		IUserInfoDao userInfoDao=null;
		SqlSession session=null;
		try {
			//获得映射文件
			session=openSession();
			userInfoDao=session.getMapper(IUserInfoDao.class);
			    //执行映射文件中id的sql语句
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
