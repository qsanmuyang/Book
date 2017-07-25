package com.cxit.books.dao;

import java.util.List;
import java.util.Map;

import com.cxit.books.model.Books;

public interface IBooksDao {
	//接口得方法签名 和mapper配置节点的id同名
		public List<Books> getAllBooks();
		//添加图书
		public int addBook(Books b);
		//修改图书
		public int updateBook(Books b);
		//删除图书
		public int deleteBook(int bid);
		//查找图书
		public Books findBook(int bid);
		//分页列表
		public List<Books> getBooksByPage(Map<String,Integer> map);
		
}
