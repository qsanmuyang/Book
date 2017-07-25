package com.cxit.books.dao;

import java.util.List;

import com.cxit.books.model.Orders;

public interface IOrdersDao {
	public List<Orders> getOrders();
	public int addOrder(Orders o);
	public int deleteOrder(Orders o);
	public List<Orders> getOrdersByUserName(String name);
	public List<Orders> getAllOrders2();
	public int getMaxOid();
}
