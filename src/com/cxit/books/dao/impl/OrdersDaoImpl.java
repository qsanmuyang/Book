package com.cxit.books.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cxit.books.dao.IOrdersDao;
import com.cxit.books.model.Orders;
import com.cxit.books.util.BaseDao;
@Repository
public class OrdersDaoImpl extends BaseDao {
	public List<Orders> getOrders(){
		List<Orders> orderList = new ArrayList<Orders>();
		IOrdersDao iOrdersDao =null;
		SqlSession session=null;
		try {
			session = openSession();
			iOrdersDao = session.getMapper(IOrdersDao.class);
			orderList = iOrdersDao.getOrders();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iOrdersDao=null;
		}
		return orderList;
	}
	public int addOrder(Orders o){
		int num=0;
		IOrdersDao iOrdersDao =null;
		SqlSession session=null;
		try {
			session =openSession();
			iOrdersDao = session.getMapper(IOrdersDao.class);
			num = iOrdersDao.addOrder(o);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iOrdersDao=null;
		}
		return num;
	}
	public int deleteOrder(Orders o){
		int num=0;
		IOrdersDao iOrdersDao =null;
		SqlSession session=null;
		try {
			session =openSession();
			iOrdersDao = session.getMapper(IOrdersDao.class);
			num = iOrdersDao.deleteOrder(o);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iOrdersDao=null;
		}
		return num;
	}
	public List<Orders> getOrdersByUserName(String name){
		List<Orders> orderList = new ArrayList<Orders>();
		IOrdersDao iOrdersDao =null;
		SqlSession session=null;
		try {
			session = openSession();
			iOrdersDao = session.getMapper(IOrdersDao.class);
			orderList = iOrdersDao.getOrdersByUserName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iOrdersDao=null;
		}
		return orderList;
	}
	public List<Orders> getAllOrders2(){
		List<Orders> orderList = new ArrayList<Orders>();
		IOrdersDao iOrdersDao =null;
		SqlSession session=null;
		try {
			session = openSession();
			iOrdersDao = session.getMapper(IOrdersDao.class);
			orderList = iOrdersDao.getAllOrders2();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iOrdersDao=null;
		}
		return orderList;
	}
	public int getMaxOid(){
		int num=0;
		IOrdersDao iOrdersDao =null;
		SqlSession session=null;
		try {
			session =openSession();
			iOrdersDao = session.getMapper(IOrdersDao.class);
			num = iOrdersDao.getMaxOid();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iOrdersDao=null;
		}
		return num+1;
	}
}
