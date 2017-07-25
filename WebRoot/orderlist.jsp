<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="checkLogin.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript">
	var currentPage;
	window.onload=function(){
	currentPage=1;
	goPage(1);
	}
	
	function goPage(num){
	$("#orderlist").empty();
	currentPage=num;
	var current=num;
	  for(var i=1;i<=${OPAGES};i++){
	  if(i==current){
	  $("#page"+i+"").addClass("current");
	  }else{
	  $("#page"+i+"").removeClass("current");
	  }
	  }
	var url="servlet/itemsControl.do?opr=orderlist&currentPage="+num;
	$.post(url,function(orders){
	buyList(orders);
	},"json");
	}
	function buyList(orders){
	$("#orderlist").append("<tr class='title'><th class='orderId'>订单编号</th>"+
	"<th>订单商品</th><th class='userName'>收货人</th><th class='price'>订单金额</th>"+
	"<th class='createTime'>下单时间</th><th class='status'>订单状态</th></tr>");
	for(var i=0;i<orders.length;i++){
	var o = orders[i];
	var allmoney=o.price*o.count;
	$("#orderlist").append("<tr><td>"+o.oid+"</td><td class='thumb'><img src='"+o.image+"' />"+
	"</td><td>"+o.userName+"</td><td>￥"+allmoney+"</td><td>"+o.date+"</td><td>已完成</td></tr>");
	}
	}
	function goLeft(){
	currentPage=currentPage-1;
	if(currentPage==0){
	currentPage=${OPAGES};
	}
	goPage(currentPage);
	}
	function goRight(){
	currentPage=currentPage+1;
	if(currentPage>${OPAGES}){
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
				<li><a href="index.jsp">User首页</a></li>
				<li class="current"><a href="orderlist.jsp">我的订单</a></li>
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
	<div class="list orderList">
			<table id="orderlist">
				
			</table>
			<div class="page-spliter">
				<a href="javascript:;" onclick="goLeft()">&lt;</a>
				<a href="javascript:;" onclick="goPage(1)">首页</a>
				<c:forEach begin="1" end="${OPAGES}" step="1" var="page" varStatus="p">
				<a href="javascript:;" onclick="goPage(${p.index })" id="page${p.index }">${p.index }</a>
				</c:forEach>
				<a href="javascript:;" onclick="goPage(${OPAGES})">尾页</a>
				<a href="javascript:;" onclick="goRight()">&gt;</a>
			</div>
			<div class="button"><input class="input-gray" type="submit" name="submit" value="查看一个月前的订单" /><input class="input-gray" type="submit" name="submit" value="查看一个月前的订单" /></div>
	</div>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
