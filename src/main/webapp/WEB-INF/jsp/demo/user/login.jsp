<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
<head>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/common/css/style.css" type="text/css">
<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/common/css/index.css"/>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>登录</title>
  <script src="<%=request.getContextPath() %>/common/js/index.js"></script>
</head>
<body onload="onload()">

  <section class="container">
    <div class="login">
      <h1>用户登录</h1>
      <form method="post" action="login"  onsubmit="return checkLogin()">
        <p><input type="text" name="name" id="name" value="" placeholder="用户名"></p>
        <p><input type="password" name="password" id="password" value="" placeholder="密码"></p>
        <p><span class="tips" id="divname"></span></p>
<!--         <p class="remember_me"> -->
<!--           <label> -->
<!--             <input type="checkbox" name="remember_me" id="remember_me"> -->
<!--             记住密码 -->
<!--           </label> -->
<!--         </p> -->
        <p class="submit"><input type="submit" name="commit" value="登录"></p>
      </form>
    </div>

    <div class="login-help">
      <p> <a href="<%=request.getContextPath() %>/demo/user/add">注册新用户</a></p>
    </div>
  </section>
<script>
function onload(){
	var a ='<%=request.getAttribute("error")%>';
	if(a=='null'||a==""){
		
	}else{
		divname.innerHTML='<font class="tips_false">用户名或密码错误 ！ </font>';
	}
}
</script>
</body>
</html>

