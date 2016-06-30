<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hesc.demo.pojo.ToAlbum"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>相册集</title>
</head>
<body>
<form>
	<table border="1">
		<tr>
			<td><a href="<%=request.getContextPath() %>/demo/album_photo/list">我的相册</a></td>
<!-- 			<td>好友相册</td> -->
			<td><a href="<%=request.getContextPath() %>/demo/user/${user.id }/update">个人设置</a></td>
		</tr>
	</table>
	欢迎${user.name}  登录相册系统
	<input type="button" value="退出"
	 onclick="location.href='<%=request.getContextPath() %>/demo/user/login';"/><br/>
	
	<input type="button" value="上传照片" 
	onclick="location.href='<%=request.getContextPath() %>/demo/album/add';"/>
	<input type="button" value="查看日志"
	onclick="location.href='<%=request.getContextPath() %>/demo/log/list';"/>
	<table border="1">
		<tr>
			<td>照片名</td>
			<td>图片</td>
			<td>创建人</td>
			<td>上传时间</td>
			<td>照片描述</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${albumlist_1 }" var="toalbum">
		<tr>
			<td>${toalbum.picture_name}</td>
			<td><img id="image" src="<%=request.getContextPath() %>/images/load/${toalbum.url}" width="48" height="48"></td>
			<td>${toalbum.name}</td>
			<td>${toalbum.createTime}</td>
			<td>${toalbum.description}</td>
			<td>
				<a href="<%=request.getContextPath() %>/demo/album/${toalbum.id }/update">编辑</a>
				<a href="<%=request.getContextPath() %>/demo/album/${toalbum.id }/delete">删除</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</form>
</body>
</html>
