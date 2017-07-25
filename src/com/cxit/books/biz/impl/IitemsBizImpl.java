package com.cxit.books.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxit.books.biz.IitemsBiz;
import com.cxit.books.dao.impl.IitemsDaoImpl;
import com.cxit.books.model.Items;
import com.cxit.books.model.shopping;
@Service
public class IitemsBizImpl implements IitemsBiz {
	@Autowired
	private IitemsDaoImpl iDaoImpl;
	
	public IitemsDaoImpl getiDaoImpl() {
		return iDaoImpl;
	}

	public void setiDaoImpl(IitemsDaoImpl iDaoImpl) {
		this.iDaoImpl = iDaoImpl;
	}

	@Override
	public int addItems(Items Item) {
		return iDaoImpl.addItem(Item);
	}

	@Override
	public int updateItems(Items Item) {
		return iDaoImpl.updateItem(Item);
	}

	@Override
	public int deleteItems(int id) {
		return iDaoImpl.deleteItem(id);
	}

	@Override
	public Items getItemsById(int id) {
		return iDaoImpl.getItemByIid(id);
	}

	@Override
	public List<Items> getAllItems() {
		return iDaoImpl.getItems();
	}

	@Override
	public List<Items> getItemsByName(String name) {
		return iDaoImpl.queryItemsByName(name);
	}

	@Override
	public List<shopping> getShopByName(String name) {
		return iDaoImpl.queryShop(name);
	}

	@Override
	public List<shopping> getBuyByName(String name) {
		
		return iDaoImpl.queryBuy(name);
	}

	@Override
	public int updateBuy(String name) {
		
		return iDaoImpl.updateBuy(name);
	}
	@Override
	public int countBeginPosition(int currentPage, int pageNum) {
		return (currentPage-1)*pageNum;
	}

	@Override
	public int countPage(int pageNum,String name) {
		int num = iDaoImpl.queryBuy(name).size();
		int countPage=0;
		if(num%pageNum==0){
			countPage=num/pageNum;
		}else{
			countPage=num/pageNum+1;
		}
		return countPage;
	}

	@Override
	public List<shopping> itemsBuy(Map map) {
		return iDaoImpl.getBuysByName(map);
	}
}
