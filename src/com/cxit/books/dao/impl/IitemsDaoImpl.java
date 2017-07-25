package com.cxit.books.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cxit.books.dao.IitemsDao;
import com.cxit.books.model.Items;
import com.cxit.books.model.ItemsData;
import com.cxit.books.model.shopping;
import com.cxit.books.util.BaseDao;
@Repository
public class IitemsDaoImpl extends BaseDao {
	private IitemsDao iitemsDao;
	public List<Items> getItems(){
		List<Items> itemsList = new ArrayList<Items>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsList = iitemsDao.getAllItems();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsList;
	}
	public int addItem(Items i){
		int num=0;
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			num = iitemsDao.addItem(i);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return num;
	}
	public int updateItem(Items i){
		int num=0;
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			num = iitemsDao.updateItem(i);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return num;
	}
	public int deleteItem(int iid){
		int num=0;
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			num = iitemsDao.deleteItem(iid);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return num;
	}
	public Items getItemByIid(int iid){
		Items items = null;
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session .getMapper(IitemsDao.class);
			items = iitemsDao.findItem(iid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return items;
	}
	public Items getItemByIid2(int iid){
		Items items = null;
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session .getMapper(IitemsDao.class);
			items = iitemsDao.findItem2(iid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return items;
	}
	public List<Items> queryItems(Items i){
		List<Items> itemsList = new ArrayList<Items>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsList = iitemsDao.queryItems(i);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsList;
	}
	public List<Items> queryItems(List<Integer> list){
		List<Items> itemsList = new ArrayList<Items>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsList = iitemsDao.foreachQuery(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsList;
	}
	public List<ItemsData> queryOrderItems(int oid){
		List<ItemsData> itemsDataList =new ArrayList<ItemsData>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsDataList = iitemsDao.queryOrderItems(oid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsDataList;
	}
	public List<Items> queryItemsByName(String userName){
		List<Items> itemsList = new ArrayList<Items>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsList = iitemsDao.queryItemsByName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsList;
	}
	public List<shopping> queryShop(String name){
		List<shopping> itemsList = new ArrayList<shopping>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsList = iitemsDao.queryShop(name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsList;
	}
	public List<shopping> queryBuy(String name){
		List<shopping> itemsList = new ArrayList<shopping>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsList = iitemsDao.queryBuy(name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsList;
	}
	public int updateBuy(String username){
		int num=0;
		SqlSession session=null;
		try {
			session=openSession();
			iitemsDao=session.getMapper(IitemsDao.class);
			num=iitemsDao.updateBuy(username);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return num;
	}
	public List<shopping> getBuysByName(Map map){
		List<shopping> itemsList = new ArrayList<shopping>();
		SqlSession session=null;
		try {
			session = openSession();
			iitemsDao = session.getMapper(IitemsDao.class);
			itemsList = iitemsDao.getBuysByName(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iitemsDao=null;
		}
		return itemsList;
	}
}
