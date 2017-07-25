<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="checkLogin.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
  <script type="text/javascript">
  window.onload=function(){
  var url="servlet/itemsControl.do?opr=list";
  listShop(url);
  }
 function countMoney(ob){
 
  var iid=$(ob).attr("id");
  var count=$(ob).val();
 var url="servlet/itemsControl.do?opr=exitCount&iid="+iid+"&count="+count;
 $.get(url,function(allMoney){
 $("#allMoney").text(allMoney);
 }
 );
  }
  function listShop(url){
  var allMoney=0;
  $.get(url,function(items){
     $("#itemList").append("<tr class='title'><th class='view'>图片预览</th>"+
     "<th>书名</th><th class='nums'>数量</th><th class='price'>价格</th></tr>");
     for(var i=0;i<items.length;i++){
     allMoney=allMoney+items[i].price*items[i].count;
     if(i%2==0){
      $("#itemList").append("<tr><td class='thumb'><img src='"+items[i].image+"' /></td>"+
      "<td class='title'>"+items[i].bookName+"</td><td><input class='input-text' id='"+items[i].iid+"' type='text' name='nums' value='"+items[i].count+"' onchange='countMoney(this)' /></td>"+
      "<td>￥<span>"+items[i].price+"</span></td></tr>");
     }else{
     $("#itemList").append("<tr class='odd'><td class='thumb'><img src='"+items[i].image+"' /></td>"+
      "<td class='title'>"+items[i].bookName+"</td><td><input class='input-text' id='"+items[i].iid+"' type='text' name='nums' value='"+items[i].count+"' onchange='countMoney(this)' /></td>"+
      "<td>￥<span>"+items[i].price+"</span></td></tr>");
     }
     }
     $("#allMoney").text(allMoney);
  },"json");
  }
  </script>
 <body>
<div id="header" class="wrap">
	<div id="logo">传习教育网上书城</div>
	<div id="navbar">
		<div class="userMenu">
			<ul>
				<li><a href="index.jsp">User首页</a></li>
				<li><a href="orderlist.jsp">我的订单</a></li>
				<li class="current"><a href="shopping.jsp">购物车</a></li>
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
		<form method="post" name="shoping" action="servlet/itemsControl.do?opr=buy">
			<table id="itemList">
				<h2>${msg }</h2>
			</table>
			<div class="button">
				<h4>总价：￥<span id="allMoney"></span>元</h4>
				<input class="input-chart" type="submit" name="submit" value="" />
			</div>
		</form>
	</div>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
