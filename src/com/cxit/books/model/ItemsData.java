package com.cxit.books.model;

public class ItemsData {
	//编号
	private int oid;
	//用户名
	private String userName;
	//书本名
	private String bookName;
	//创建日期
	private String createDate;
	//数量
	private int count;
	//单价
    private double price;
    //状态
	private int state;
	//总价
	private double total_Price;
	public ItemsData() {
	}
	public ItemsData(int oid, String userName, String bookName,
			String createDate, int count, double price, int state,
			double total_Price) {
		super();
		this.oid = oid;
		this.userName = userName;
		this.bookName = bookName;
		this.createDate = createDate;
		this.count = count;
		this.price = price;
		this.state = state;
		this.total_Price = total_Price;
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
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
	@Override
	public String toString() {
		return "ItemsData [oid=" + oid + ", userName=" + userName
				+ ", bookName=" + bookName + ", createDate=" + createDate
				+ ", count=" + count + ", price=" + price + ", state=" + state
				+ ", total_Price=" + total_Price + "]";
	}
	
	
}
