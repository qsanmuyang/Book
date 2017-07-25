package com.cxit.books.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cxit.books.biz.impl.BookBizImpl;
import com.cxit.books.biz.impl.IitemsBizImpl;
import com.cxit.books.model.Books;

public class BooksManagerServlet extends HttpServlet {
	private BookBizImpl bizImpl;
	private IitemsBizImpl iBizImpl;
	
	
	public IitemsBizImpl getiBizImpl() {
		return iBizImpl;
	}
	public void setiBizImpl(IitemsBizImpl iBizImpl) {
		this.iBizImpl = iBizImpl;
	}
	public BookBizImpl getBizImpl() {
		return bizImpl;
	}
	public void setBizImpl(BookBizImpl bizImpl) {
		this.bizImpl = bizImpl;
	}
	public BooksManagerServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("LOGIN");
		String opr=request.getParameter("opr");
		session.removeAttribute("msg");
		if(opr.equals("index")){
			int pages=bizImpl.countPage(3);
			int bugpages=iBizImpl.countPage(3, name);
			session.setAttribute("PAGES", pages);
			session.setAttribute("OPAGES", bugpages);
			response.sendRedirect("../index.jsp");
		}
		if(opr.equals("bookList")){
			String page=request.getParameter("currentPage");
			int currentPage=Integer.parseInt(page);
			int pageNum=3;
			int begin=bizImpl.countBeginPosition(currentPage, pageNum);
			Map<String,Integer> map = new HashMap<String, Integer>();
			map.put("begin", begin);
			map.put("pageNum", pageNum);
			List<Books> books=bizImpl.getBooksByPage(map);
			JSONArray jo=JSONArray.fromObject(books);
			out.print(jo);
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		WebApplicationContext wac=
				WebApplicationContextUtils.
				  getRequiredWebApplicationContext(this.getServletContext());
		bizImpl=(BookBizImpl) wac.getBean("bookBizImpl");
		iBizImpl=(IitemsBizImpl) wac.getBean("iitemsBizImpl");
	}

}
