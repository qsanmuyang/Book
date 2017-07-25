package com.cxit.books.biz;

import java.util.List;
import java.util.Map;

import com.cxit.books.model.Books;

/**
 * �鼮��Ϣҵ��ӿ�
 * @author ��ɭ��
 *
 */
public interface IBookBiz {
  //����鼮
  public int addBook(Books book);
  //�޸��鼮
  public int updateBook(Books book);
  //ɾ���鼮��Ϣ
  public int deleteBook(int bid);
  //ͨ����������鼮����
  public Books getBookById(int bid);
  //��������鼮����
  public List<Books> getAllBooks();
  //��÷�ҳ�鼮����
  public List<Books> getBooksByPage(Map<String, Integer> map);
  //�����ҳ��ʼλ��
  public int countBeginPosition(int currentPage,int pageNum);
  //�����ܵ�ҳ��
  public int countPage(int pageNum);
}
