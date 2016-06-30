<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hesc.demo.pojo.ToLog"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志记录</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/demo/log/search" method="get">
		<input name="key" type="text" />
		<input type="submit"  value="搜索" />
</form>
<form>
	<table border="1">
		<tr>
			<td><a href="<%=request.getContextPath() %>/demo/album_photo/list">我的相册</a></td>
<!-- 			<td>好友相册</td> -->
			<td><a href="<%=request.getContextPath() %>/demo/user/${user.id }/update">个人设置</a></td>
		</tr>
	</table>
	欢迎      ${user.name}  登录相册系统
	<input type="button" value="退出"
	 onclick="location.href='<%=request.getContextPath() %>/demo/user/login';"/><br/>
	
	<input type="button" value="上传照片" 
	onclick="location.href='<%=request.getContextPath() %>/demo/album/add';"/>
	<input type="button" value="查看日志"
	onclick="location.href='<%=request.getContextPath() %>/demo/log/list';"/>
	
	<table border="1">
		<tr>
			<td>用户名</td>
			<td>操作时间</td>
			<td>操作类型</td>
		</tr>
	<c:forEach items="${list_1 }" var="tolog">
		<tr>
			<td>${tolog.name}</td>
			<td>${tolog.createTime}</td>
			<td>${tolog.operation}</td>
<!-- 			<td> -->
<%-- 				<a href="${log.id}">查看</a> --%>
<%-- 				<a href="${log.id}/update">编辑</a> --%>
<%-- 				<a href="${log.id}/delete">删除</a> --%>
<!-- 			</td> -->
		</tr>
	</c:forEach>
		<tr>
			<td><a href="<%=request.getContextPath() %>/demo/log/listbefore?curPage=1&pageCount=${page.pageCount}">首页</a>	<a href="<%=request.getContextPath() %>/demo/log/listbefore?curPage=${page.curPage}&pageCount=${page.pageCount}">上一页</a>	第 ${page.curPage }/${page.pageCount } 页	<a href="<%=request.getContextPath() %>/demo/log/listnext?curPage=${page.curPage}&pageCount=${page.pageCount}">下一页</a>	<a href="<%=request.getContextPath() %>/demo/log/listnext?curPage=${page.pageCount}&pageCount=${page.pageCount}">尾页</a></td>
		</tr>
	</table>
</form>

</body>
</html>
