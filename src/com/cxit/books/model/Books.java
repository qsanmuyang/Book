package com.cxit.books.model;
/**
 * 书籍实体类
 * @author 钟森阳
 *
 */
public class Books {
	private int bid;//图书编号
	private String bookName;//图书名称
	private double b_price;//图书价格
	private String image;//图片
	private int stock;//库存数量
	public Books(){
	}
	public Books(int bid, String bookName, double price, String image, int stock) {
		super();
		this.bid = bid;
		this.bookName = bookName;
		this.b_price = price;
		this.image = image;
		this.stock = stock;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return b_price;
	}
	public void setPrice(double price) {
		this.b_price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bookName=" + bookName + ", price="
				+ b_price + ", image=" + image + ", stock=" + stock + "]";
	}
	
	
}
