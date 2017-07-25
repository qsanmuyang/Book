package com.cxit.books.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxit.books.biz.IUserInfoBiz;
import com.cxit.books.dao.impl.UserInfoDaoImpl;
import com.cxit.books.model.UserInfo;
@Service
public class UserInfoBizImpl implements IUserInfoBiz {
	@Autowired
	private UserInfoDaoImpl uInfoDaoImpl;
	public UserInfoDaoImpl getuInfoDaoImpl() {
		return uInfoDaoImpl;
	}
	public void setuInfoDaoImpl(UserInfoDaoImpl uInfoDaoImpl) {
		this.uInfoDaoImpl = uInfoDaoImpl;
	}

	@Override
	public boolean login(UserInfo u) {
		boolean flag=false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("n", u.getUserName());
		map.put("p", u.getPassWord());
		UserInfo userInfo =uInfoDaoImpl.findUser(map);
		if(userInfo!=null){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

	@Override
	public int regist(UserInfo u) {
		int result =uInfoDaoImpl.addUserInfo(u);
		return result;
	}

	@Override
	public int delUserByUserName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserInfo> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean findUser(String name) {
		boolean flag=false;
		UserInfo userInfo = uInfoDaoImpl.getUserByName(name);
		if(userInfo!=null){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

}
