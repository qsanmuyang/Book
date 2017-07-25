package com.cxit.books.model;

public class shopping {
	private int iid;
	private int oid;
	private String image;
	private String bookName;
	private int count;
	private double price;
	private String date;
	private String userName;
	public shopping() {
	}
	
	public shopping(int iid, String image, String bookName, int count,
			double price) {
		super();
		this.iid = iid;
		this.image = image;
		this.bookName = bookName;
		this.count = count;
		this.price = price;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "shopping [iid=" + iid + ", oid=" + oid + ", image=" + image
				+ ", bookName=" + bookName + ", count=" + count + ", price="
				+ price + ", date=" + date + ", userName=" + userName + "]";
	}

	

	

	
	
	
	
}
