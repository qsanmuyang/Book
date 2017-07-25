package com.cxit.books.model;

import java.util.List;
/**
 * 订单实体类
 * @author 钟森阳
 * 一个订单 关联了多个订单项
 */
public class Orders {
	//订单编号
	private int oid;
    //用户名
	private String userName;
	//在一的一方 定义多的一方集合
	private List<Items> oitems;
	public Orders() {
	}
	public Orders(int oid, String userName) {
		super();
		this.oid = oid;
		this.userName = userName;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Items> getOitems() {
		return oitems;
	}
	public void setOitems(List<Items> oitems) {
		this.oitems = oitems;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", userName=" + userName + "]";
	}
	

}
