package com.cxit.books.model;
/**
 * �鼮ʵ����
 * @author ��ɭ��
 *
 */
public class Books {
	private int bid;//ͼ����
	private String bookName;//ͼ������
	private double b_price;//ͼ��۸�
	private String image;//ͼƬ
	private int stock;//�������
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
