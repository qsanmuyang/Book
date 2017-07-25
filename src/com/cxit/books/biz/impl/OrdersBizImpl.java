package com.cxit.books.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxit.books.biz.IOrdersBiz;
import com.cxit.books.dao.impl.OrdersDaoImpl;
import com.cxit.books.model.Orders;
@Service
public class OrdersBizImpl implements IOrdersBiz {
	@Autowired
	private OrdersDaoImpl oDaoImpl;
	
	
	public OrdersDaoImpl getoDaoImpl() {
		return oDaoImpl;
	}

	public void setoDaoImpl(OrdersDaoImpl oDaoImpl) {
		this.oDaoImpl = oDaoImpl;
	}

	@Override
	public int addOrders(Orders Orders) {
		// TODO Auto-generated method stub
		return oDaoImpl.addOrder(Orders);
	}

	@Override
	public int updateOrders(Orders Orders) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrders(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orders getOrdersById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getOrderByName(String name) {
		
		return oDaoImpl.getOrdersByUserName(name);
	}

	@Override
	public int getMaxOid() {
		return oDaoImpl.getMaxOid();
	}

}
