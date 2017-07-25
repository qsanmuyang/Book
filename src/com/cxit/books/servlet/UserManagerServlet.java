package com.cxit.books.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cxit.books.biz.impl.BookBizImpl;
import com.cxit.books.biz.impl.OrdersBizImpl;
import com.cxit.books.biz.impl.UserInfoBizImpl;
import com.cxit.books.model.Orders;
import com.cxit.books.model.UserInfo;


public class UserManagerServlet extends HttpServlet {
	private UserInfoBizImpl userBizImpl;
	private OrdersBizImpl oBizImpl;
	
	
	public OrdersBizImpl getoBizImpl() {
		return oBizImpl;
	}
	public void setoBizImpl(OrdersBizImpl oBizImpl) {
		this.oBizImpl = oBizImpl;
	}
	public UserInfoBizImpl getUserBizImpl() {
		return userBizImpl;
	}
	public void setUserBizImpl(UserInfoBizImpl userBizImpl) {
		this.userBizImpl = userBizImpl;
	}
	public UserManagerServlet() {
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
		session.removeAttribute("msg");
		String opr =request.getParameter("opr");
		if(opr.equals("delLogin")){
			session.removeAttribute("LOGIN");
			response.sendRedirect("../login.jsp");
		}else if(opr.equals("login")){
			String userName=request.getParameter("userName");
			String passWord=request.getParameter("passWord");
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(userName);
			userInfo.setPassWord(passWord);
			RequestDispatcher dispatcher=null;
			boolean flag=userBizImpl.login(userInfo);
			ServletContext application = this.getServletContext();
			if(flag){
				session.setAttribute("LOGIN", userName);
				List<UserInfo> userList =new ArrayList<UserInfo>();
				if(application.getAttribute("LOGIN_USER")!=null){
					userList=(List<UserInfo>) application.getAttribute("LOGIN_USER");
				}
				userList.add(userInfo);
				application.setAttribute("LOGIN_USER", userList);
				dispatcher=request.getRequestDispatcher("booksControl.do?opr=index");
				dispatcher.forward(request, response);
			}else{
				dispatcher=request.getRequestDispatcher("../login.jsp");
				dispatcher.forward(request, response);
			}
		}else if(opr.equals("add")){
			String userName=request.getParameter("userName");
			String passWord=request.getParameter("passWord");
			String email=request.getParameter("email");
			UserInfo u =new UserInfo(userName, passWord,email);
			int result = userBizImpl.regist(u);
			if(result>0){
				response.sendRedirect("../register_success.html");
			}else{
				response.sendRedirect("../register.jsp");
			}
		}else if(opr.equals("findUser")){
			String userName=request.getParameter("userName");
			boolean result =userBizImpl.findUser(userName);
			if(result){
				out.print(false);
			}else{
				out.print(true);
			}
		}
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		WebApplicationContext wac =WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		userBizImpl =(UserInfoBizImpl) wac.getBean("userInfoBizImpl");
		oBizImpl=(OrdersBizImpl) wac.getBean("ordersBizImpl");
	}

}
