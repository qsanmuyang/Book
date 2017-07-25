package com.cxit.books.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cxit.books.dao.IBooksDao;
import com.cxit.books.model.Books;
import com.cxit.books.util.BaseDao;
@Repository
public class BooksDaoImpl extends BaseDao {
	private IBooksDao iBooksDao;
	public List<Books> getBooks(){
		List<Books> bookList = new ArrayList<Books>();
		SqlSession session=null;
		try {
			session=openSession();
			iBooksDao=session.getMapper(IBooksDao.class);
			bookList = iBooksDao.getAllBooks();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iBooksDao=null;
		}
		return bookList;
	}
	public int addBook(Books b){
		int num=0;
		SqlSession session=null;
		try {
			session =openSession();
			iBooksDao=session.getMapper(IBooksDao.class);
			num=iBooksDao.addBook(b);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iBooksDao=null;
		}
		return num;
	}
	public int updateBook(Books b){
		int num=0;
		SqlSession session=null;
		try {
			session = openSession();
			iBooksDao = session.getMapper(IBooksDao.class);
			num=iBooksDao.updateBook(b);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iBooksDao=null;
		}
		return num;
	}
	public int deleteBook(int bid){
		int num=0;
		SqlSession session =null;
		try {
			session = openSession();
			iBooksDao = session.getMapper(IBooksDao.class);
			num = iBooksDao.deleteBook(bid);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iBooksDao=null;
		}
		return num;
	}
	public Books getBookByUid(int bid){
		Books books = null;
		SqlSession session =null;
		try {
			session = openSession();
			iBooksDao = session.getMapper(IBooksDao.class);
			books = iBooksDao.findBook(bid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iBooksDao=null;
		}
		return books;
	}
	public List<Books> getBooksByPage(Map<String,Integer> map){
		List<Books> bookList = new ArrayList<Books>();
		SqlSession session=null;
		try {
			session=openSession();
			iBooksDao=session.getMapper(IBooksDao.class);
			bookList = iBooksDao.getBooksByPage(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			iBooksDao=null;
		}
		return bookList;
	}
}
