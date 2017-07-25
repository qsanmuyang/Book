<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  </head>
  
  <body>
<div id="header" class="wrap">
	<div id="logo">传习教育网上书城</div>
	<div id="navbar">
		<form method="get" name="search" action="">
			搜索：<input class="input-text" type="text" name="keywords" /><input class="input-btn" type="submit" name="submit" value="" />
		</form>
	</div>
</div>
<div id="login">
	<h2>用户登陆</h2>
	<form method="post" action="servlet/userControl.do?opr=login">
		<dl>
			<dt>用户名：</dt>
			<dd><input class="input-text" id="userName" type="text" name="userName" onblur="checkUserExists()"/><span id="isExist"></span></dd>
			<dt>密　码：</dt>
			<dd><input class="input-text" id="passWord" type="password" name="passWord" onblur="checkPwd()"/><span id="isEasy"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-btn" type="submit" name="submit" value="" /><input class="input-reg" type="button" name="register" value="" onclick="window.location='register.jsp';" /></dd>
		</dl>
	</form>
	<script type="text/javascript">
	function checkUserExists(){
	var un=$("#userName").val();
	if(un==""){
	  $("#isExist").text("用户名不能为空！");
	  $("#isExist").css("color","red");
	}else{
	  var url="servlet/userControl.do?opr=findUser&userName="+un;
	  $.get(url,function(data){
	      if(data=="true"){
	      $("#isExist").text("当前用户不存在！");
	      $("#isExist").css("color","red");
	    }else{
	      $("#isExist").text("当前用户存在！");
	      $("#isExist").css("color","green");
	    }
	  });
	}
	}
	function checkPwd(){
	if($("#passWord").val()==""){
	    $("#isEasy").html("密码不能为空！");
	    $("#isEasy").css("color","red");
	}else{
	  if($("#passWord").val().length>5){
	    $("#isEasy").html("密码可以使用！");
	    $("#isEasy").css("color","green");
	 }else{
	    $("#isEasy").html("密码过于简单！");
	    $("#isEasy").css("color","red");
	 }
	}
	}
	</script>
</div>
<div id="footer" class="wrap">
	传习教育网上书城 &copy; 版权所有

</div>
</body>
</html>
