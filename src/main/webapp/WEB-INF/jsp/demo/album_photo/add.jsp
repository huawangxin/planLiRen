<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加相册</title>
</head>
<body>
<sf:form method="post" modelAttribute="album_photolist" onsubmit="return checkPhoto()">
<table>
	<tr>
		<td>相册名: </td>
		<td><sf:input path="album_name"/> <sf:errors path="album_name" />
		<sf:hidden path="name" value="${user.name }"/>
		</td>
	</tr>
	<tr>
		<td>相册描述:</td>
		<td><sf:textarea path="description"/> <sf:errors path="description" />
		</td>
	</tr>
	<tr>
		<td></td>
		<td>
			<input type="submit" value="提 交" />
			<input type="reset" value="重置" />
		</td>
	</tr>
</table>
</sf:form>

<script type="text/javascript">
function checkPhoto(){
	var album_name=document.getElementById("album_name").value;  
	var description=document.getElementById("description").value;
	if(album_name==""){  
	     alert("输入框中不能为空！ "); 
	     return false;
	}else{
		var patrn1=/^[\u4e00-\u9fa5]{1,10}$/;
	     var patrn2=/^\S{0,255}$/;
	     if (!patrn1.exec(album_name)){
	        alert("名称为1至10个汉字");
	        //name.focus();
	        return false;
	     }else if(!patrn2.exec(description)){  
		     alert("描述输入内容过多 ");
		     return false;
		 }else{
			 alert('新相册创建成功！ ');
		     return true;
		}
	}
}
</script>
</body>
</html>
