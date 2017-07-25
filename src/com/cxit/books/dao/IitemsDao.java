package com.cxit.books.dao;

import java.util.List;
import java.util.Map;

import com.cxit.books.model.Items;
import com.cxit.books.model.ItemsData;
import com.cxit.books.model.shopping;

public interface IitemsDao {

		public List<Items> getAllItems();

		public int addItem(Items i);

		public int updateItem(Items i);

		public int deleteItem(int iid);

		public Items findItem(int iid);
		
		public Items findItem2(int iid);
		
		public List<Items> queryItems(Items i);
		public List<Items> foreachQuery(List<Integer> list);
		public List<ItemsData> queryOrderItems(int oid);
		public List<Items> queryItemsByName(String userName);
		public List<shopping> queryShop(String userName);
		public List<shopping> queryBuy(String userName);
		public int updateBuy(String username);
		//∑÷“≥¡–±Ì
		public List<shopping> getBuysByName(Map map);
}
