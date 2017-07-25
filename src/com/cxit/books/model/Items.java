package com.cxit.books.model;

public class Items {
    //���
	private int iid;
    //�������
	private int oid;
	//�����Ķ�������
	private Orders iorders;
    //�鼮���
	private int bid;
    //��������
	private String createDate;
    //����
	private int count;
    //����
	private double price;
	//״̬
	private int state;
    //�ܼ�
	private double total_Price;
	public Items() {
	}
	public Items(int iid, int oid, int bid, String createDate, int count,
			double price, int state, double totalPrice) {
		super();
		this.iid = iid;
		this.oid = oid;
		this.bid = bid;
		this.createDate = createDate;
		this.count = count;
		this.price = price;
		this.state = state;
		this.total_Price = totalPrice;
	}
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public double getTotal_Price() {
		return total_Price;
	}
	public void setTotal_Price(double total_Price) {
		this.total_Price = total_Price;
	}
	
	public Orders getIorders() {
		return iorders;
	}
	public void setIorders(Orders iorders) {
		this.iorders = iorders;
	}
	@Override
	public String toString() {
		return "Items [iid=" + iid + ", oid=" + oid + ", bid=" + bid
				+ ", createDate=" + createDate + ", count=" + count
				+ ", price=" + price + ", state=" + state + ", totalPrice="
				+ total_Price + "]";
	}
	
	

}
