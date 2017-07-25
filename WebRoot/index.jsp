<%@page import="com.cxit.books.biz.impl.BookBizImpl"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="checkLogin.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>传习教育网上书城</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
	var currentPage;
	window.onload=function(){
	  currentPage=1;
	  goPage(currentPage);
	}
	function bookList(books){
	  $("#bookList").append("<tr class='title'><th class='checker'></th>"+
	  "<th>书名</th><th class='price'>价格</th><th class='store'>库存</th>"+
	  "<th class='view'>图片预览</th></tr>");
	  for(var i=0;i<books.length;i++){
	   var b=books[i];
	   if(i%2==0){
	   $("#bookList").append("<tr class='odd'><td><input type='checkbox' name='bookId' value='"+b.bid+"' /></td>"+
	   "<td class='title'>"+b.bookName+"</td><td>"+b.price+"</td><td>"+b.stock+"</td>"+
	   "<td class='thumb'><img src='"+b.image+"' /></td></tr>");
	   }else{
	   $("#bookList").append("<tr><td><input type='checkbox' name='bookId' value='"+b.bid+"' /></td>"+
	   "<td class='title'>"+b.bookName+"</td><td>"+b.price+"</td><td>"+b.stock+"</td>"+
	   "<td class='thumb'><img src='"+b.image+"' /></td></tr>");
	   }
	  }
	}
	function goPage(num){
	$("#bookList").empty();
	currentPage=num;
	var current=num;
	 for(var i=1;i<=${PAGES};i++){
	  if(i==current){
	  $("#page"+i+"").addClass("current");
	  }else{
	  $("#page"+i+"").removeClass("current");
	  }
	  }
	var url="servlet/booksControl.do?opr=bookList&currentPage="+num;
	$.post(url,function(books){
	bookList(books);
	},"json");
	}
	function goLeft(){
	currentPage=currentPage-1;
	if(currentPage==0){
	currentPage=${PAGES};
	}
	goPage(currentPage);
	}
	function goRight(){
	currentPage=currentPage+1;
	if(currentPage>${PAGES}){
	currentPage=1;
	}
	goPage(currentPage);
	}
	</script>
  </head>
  <body>
<div id="header" class="wrap">
	<div id="logo">传习教育网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li class="current"><a href="index.jsp">User首页</a></li>
				<li><a href="orderlist.jsp">我的订单</a></li>
				<li><a href="shopping.jsp">购物车</a></li>
				<li><a href="servlet/userControl.do?opr=delLogin">注销</a></li>
			</ul>
		</div>
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="content" class="wrap">
	<div class="list bookList">
		<form method="post" name="shoping" action="servlet/itemsControl.do?opr=addBook">
			<table id="bookList">
				
			</table>
			<div class="page-spliter">
				<a href="javascript:;" onclick="goLeft()">&lt;</a>
				<a href="javascript:;" onclick="goPage(1)">首页</a>
				<c:forEach begin="1" end="${PAGES}" step="1" var="page" varStatus="p">
				<a href="javascript:;" onclick="goPage(${p.index })" id="page${p.index }">${p.index }</a>
				</c:forEach>
				<a href="javascript:;" onclick="goPage(${PAGES})">尾页</a>
				<a href="javascript:;" onclick="goRight()">&gt;</a>
			</div>
			<div class="button"><input class="input-btn" type="submit" name="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
