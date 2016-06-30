<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hesc.demo.pojo.ToAlbum_photo"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的相册</title>
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
	
	<input type="button" value="新建相册" 
	onclick="location.href='<%=request.getContextPath() %>/demo/album_photo/add';"/>
	<input type="button" value="查看日志"
	onclick="location.href='<%=request.getContextPath() %>/demo/log/list';"/>
	<table border="1">
		<tr>
			<td>相册名</td>
			<td>创建人</td>
			<td>创建时间</td>
			<td>相册描述</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${album_photolist_1 }" var="toalbum">
		<tr>
			<td>${toalbum.album_name}</td>
			<td>${toalbum.name}</td>
			<td>${toalbum.createTime}</td>
			<td>${toalbum.description}</td>
			<td><a href="<%=request.getContextPath() %>/demo/album_photo/${toalbum.id }">查看</a>
				<a href="<%=request.getContextPath() %>/demo/album_photo/${toalbum.id }/update">编辑</a>
				<a href="<%=request.getContextPath() %>/demo/album_photo/${toalbum.id }/delete">删除</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</form>
</body>
</html>
