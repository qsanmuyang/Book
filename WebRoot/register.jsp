<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
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
<div id="register">
	<div class="title">
		<h2>欢迎注册传习教育网上书城</h2>
	</div>
	<div class="steps">
		<ul class="clearfix">
			<li class="current">1.填写注册信息</li>
			<li class="unpass">2.注册成功</li>
		</ul>
	</div>
	<form method="post" action="servlet/userControl.do?opr=add">
		<dl>
			<dt>用 户 名：</dt>
			<dd><input class="input-text" id="userName" type="text" name="userName" onblur="checkUserExists()"/><span id="isExist"></span></dd>
			<dt>密　　码：</dt>
			<dd><input class="input-text" id="passWord" type="password" name="passWord" onblur="checkPwd()"/><span id="isEasy"></span></dd>
			<dt>确认密码：</dt>
			<dd><input class="input-text" id="rePassWord" type="password" name="rePassWord" onblur="checkRePwd()" /><span id="isSame"></span></dd>
			<dt>Email地址：</dt>
			<dd><input class="input-text" id="email" type="text" name="email" onblur="checkEmail()"/><span id="isEmail"></span></dd>
			<dt></dt>
			<dd class="button"><input class="input-reg" type="submit" name="register" value="" /></dd>
		</dl>
	</form>
	<script type="text/javascript">
	function checkUserExists(){
	var un=$("#userName").val();
	if(un==""){
	  $("#isExist").text("用户不能为空！");
	  $("#isExist").css("color","red");
	}else{
	  var url="servlet/userControl.do?opr=findUser&userName="+un;
	  $.get(url,function(data){
	      if(data=="true"){
	      $("#isExist").text("当前用户可以使用！");
	      $("#isExist").css("color","green");
	  
	    }else{
	      $("#isExist").text("当前用户名已被注册！");
	      $("#isExist").css("color","red");
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
	function checkRePwd(){
	  if($("#rePassWord").val()==""){
	   $("#isSame").html("密码不能为空！");
	    $("#isSame").css("color","red");
	  }else{
	    if($("#passWord").val()==$("#rePassWord").val()){
	    $("#isSame").html("两次密码密码一致！");
	    $("#isSame").css("color","green");
	  }else{
	    $("#isSame").html("两次密码输入不一致！");
	    $("#isSame").css("color","red");
	  }
	  }
	  
	  
	}
	function checkEmail(){
	if($("#email").val()==""){
	  $("#isEmail").html("邮箱不能为空！");
	  $("#isEmail").css("color","red");
	}else{
	 var ret=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	 if(ret.test($("#email").val())){
	   $("#isEmail").html("邮箱输入正确！");
	   $("#isEmail").css("color","green");
	 }else{
	   $("#isEmail").html("邮箱输入不正确！");
	   $("#isEmail").css("color","red");
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
