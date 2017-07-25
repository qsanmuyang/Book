package com.cxit.books.biz;

import java.util.List;
import java.util.Map;

import com.cxit.books.model.Books;

/**
 * 书籍信息业务接口
 * @author 钟森阳
 *
 */
public interface IBookBiz {
  //添加书籍
  public int addBook(Books book);
  //修改书籍
  public int updateBook(Books book);
  //删除书籍信息
  public int deleteBook(int bid);
  //通过主键获得书籍对象
  public Books getBookById(int bid);
  //获得所有书籍集合
  public List<Books> getAllBooks();
  //获得分页书籍集合
  public List<Books> getBooksByPage(Map<String, Integer> map);
  //计算分页开始位置
  public int countBeginPosition(int currentPage,int pageNum);
  //计算总的页数
  public int countPage(int pageNum);
}
