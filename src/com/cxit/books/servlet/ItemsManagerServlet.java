package com.cxit.books.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
import com.cxit.books.biz.impl.OrdersBizImpl;
import com.cxit.books.model.Books;
import com.cxit.books.model.Items;
import com.cxit.books.model.Orders;
import com.cxit.books.model.shopping;
public class ItemsManagerServlet extends HttpServlet {
	private IitemsBizImpl iBizImpl;
	private OrdersBizImpl oBizImpl;
	private BookBizImpl bookBizImpl;
	
	public OrdersBizImpl getoBizImpl() {
		return oBizImpl;
	}
	public void setoBizImpl(OrdersBizImpl oBizImpl) {
		this.oBizImpl = oBizImpl;
	}
	public IitemsBizImpl getiBizImpl() {
		return iBizImpl;
	}
	public void setiBizImpl(IitemsBizImpl iBizImpl) {
		this.iBizImpl = iBizImpl;
	}
	public ItemsManagerServlet() {
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
		String opr =request.getParameter("opr");
		String userName=(String) session.getAttribute("LOGIN");
		session.removeAttribute("msg");
		if(opr.equals("buy")){
			List<Items> itemList=new ArrayList<Items>();
			itemList=iBizImpl.getItemsByName(userName);
			int num=0;
			Date date=new Date();
			String createDate=date.toLocaleString();
			for(int i=0;i<itemList.size();i++){
				Items items=itemList.get(i);
				Books books=bookBizImpl.getBookById(items.getBid());
				int stock=books.getStock();
				if(stock>items.getCount()){
					items.setState(1);
					items.setCreateDate(createDate);
					iBizImpl.updateItems(items);
					stock-=items.getCount();
					books.setStock(stock);
					bookBizImpl.updateBook(books);
					num+=1;
				}
			}
			if(num==itemList.size()){
				int bugpages=iBizImpl.countPage(3, userName);
				session.setAttribute("OPAGES", bugpages);
				response.sendRedirect("../shopping-success.html");
			}else{
				session.setAttribute("msg", "当前有书本库存不足，请重新选择数量！");
				response.sendRedirect("../shopping.jsp");
			}
		}else if(opr.equals("orderlist")){
			String page=request.getParameter("currentPage");
			int currentPage=Integer.parseInt(page);
			int pageNum=3;
			int begin=iBizImpl.countBeginPosition(currentPage, pageNum);
			Map map = new HashMap();
			map.put("begin", begin);
			map.put("pageNum", pageNum);
			map.put("userName", userName);
			List<shopping> itemList=new ArrayList<shopping>();
			itemList=iBizImpl.itemsBuy(map);
			JSONArray jo = JSONArray.fromObject(itemList);
			out.print(jo);	
		}else if(opr.equals("addBook")){
			String [] bids=request.getParameterValues("bookId");
			int oid=oBizImpl.getMaxOid();
			Orders orders=new Orders(oid, userName);
			int length=bids.length;
			int [] bid=new int[length];
			Date date=new Date();
			int state=0;
			String createDate=date.toLocaleString();
			int count=1;
			for(int i=0;i<bids.length;i++){
				bid[i]=Integer.parseInt(bids[i]);
				Books books=bookBizImpl.getBookById(bid[i]);
				double price=books.getPrice();
				double totalPrice=books.getPrice()*count;
				Items items =new Items(0, oid, bid[i], createDate, count, price, state, totalPrice);
				iBizImpl.addItems(items);
			}
			oBizImpl.addOrders(orders);
			response.sendRedirect("../shopping.jsp");
		}if(opr.equals("list")){
			List<shopping> itemList=new ArrayList<shopping>();
			itemList=iBizImpl.getShopByName(userName);
			JSONArray jo = JSONArray.fromObject(itemList);
			out.print(jo);	
		}else if(opr.equals("exitCount")){
			String id=(String)request.getParameter("iid");
			String count1=(String)request.getParameter("count");
			int iid=Integer.parseInt(id);
			int count=Integer.parseInt(count1);
			if(count==0){
				iBizImpl.deleteItems(iid);
			}else{
				Items items =iBizImpl.getItemsById(iid);
				double allprice=items.getPrice()*count;
				Date date=new Date();
				String date1=date.toLocaleString();
				items.setCount(count);
				items.setTotal_Price(allprice);
				items.setCreateDate(date1);
				iBizImpl.updateItems(items);
			}
			List<shopping> itemList=new ArrayList<shopping>();
			itemList=iBizImpl.getShopByName(userName);
			double allMoney=0;
			for (shopping shopping : itemList) {
				allMoney+=shopping.getPrice()*shopping.getCount();
			}
			out.print(allMoney);	
		}
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		WebApplicationContext wac =WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		iBizImpl =(IitemsBizImpl) wac.getBean("iitemsBizImpl");
		oBizImpl=(OrdersBizImpl) wac.getBean("ordersBizImpl");
		bookBizImpl=(BookBizImpl) wac.getBean("bookBizImpl");
	}

}
