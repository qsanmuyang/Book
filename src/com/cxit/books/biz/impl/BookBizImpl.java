package com.cxit.books.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxit.books.biz.IBookBiz;
import com.cxit.books.dao.impl.BooksDaoImpl;
import com.cxit.books.model.Books;
@Service
public class BookBizImpl implements IBookBiz {
	@Autowired
	private BooksDaoImpl bDaoImpl;
    
	public BooksDaoImpl getbDaoImpl() {
		return bDaoImpl;
	}

	public void setbDaoImpl(BooksDaoImpl bDaoImpl) {
		this.bDaoImpl = bDaoImpl;
	}

	@Override
	public int addBook(Books book) {
		return 0;
	}

	@Override
	public int updateBook(Books book) {
		return bDaoImpl.updateBook(book);
	}

	@Override
	public int deleteBook(int bid) {
		return 0;
	}

	@Override
	public Books getBookById(int bid) {
		return bDaoImpl.getBookByUid(bid);
	}

	@Override
	public List<Books> getAllBooks() {
		
		return bDaoImpl.getBooks();
	}

	@Override
	public List<Books> getBooksByPage(Map<String, Integer> map) {
		
		return bDaoImpl.getBooksByPage(map);
	}

	@Override
	public int countBeginPosition(int currentPage, int pageNum) {
		return (currentPage-1)*pageNum;
	}

	@Override
	public int countPage(int pageNum) {
		int num = bDaoImpl.getBooks().size();
		int countPage=0;
		if(num%pageNum==0){
			countPage=num/pageNum;
		}else{
			countPage=num/pageNum+1;
		}
		return countPage;
	}

}
