package com.cxit.books.dao;

import java.util.List;
import java.util.Map;

import com.cxit.books.model.Books;

public interface IBooksDao {
	//�ӿڵ÷���ǩ�� ��mapper���ýڵ��idͬ��
		public List<Books> getAllBooks();
		//���ͼ��
		public int addBook(Books b);
		//�޸�ͼ��
		public int updateBook(Books b);
		//ɾ��ͼ��
		public int deleteBook(int bid);
		//����ͼ��
		public Books findBook(int bid);
		//��ҳ�б�
		public List<Books> getBooksByPage(Map<String,Integer> map);
		
}
