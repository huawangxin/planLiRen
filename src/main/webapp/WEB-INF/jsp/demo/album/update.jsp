<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.hesc.demo.pojo.Album_photo"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=request.getContextPath() %>/common/js/jquery.js" > </script>
<script src="<%=request.getContextPath() %>/common/js/ajaxfileupload.js"></script>
<title>更新照片信息</title>
</head>
<body>
<sf:form method="post" modelAttribute="album" onsubmit="return checkAlbum()">
<table>
	<tr>
		<td>上传作者: </td>
		<td>${album.name }</td>
	</tr>
	<tr>
		<td>所在相册: </td>
		<td>${album.album_name }</td>
	</tr>
	<tr>
		<td>照片名: </td>
		<td><sf:input path="picture_name" value="${album.picture_name }"/>
		<sf:hidden path="id" value="${album.id }"/>
		<sf:hidden path="name" value="${album.name }"/>
		<sf:hidden path="album_name" value="${album.album_name }"/>
		<sf:hidden path="album_id" value="${album.album_id }"/>
		<sf:hidden path="state" value="${album.state }"/>
		<sf:hidden path="sort" value="${album.sort }"/>
		<sf:hidden path="createTime" value="${album.createTime }"/>
		</td>
	</tr>
	<tr>
		<td>照片描述:</td>
		<td><sf:textarea path="description" value="${album.description }"/>
		</td>
	</tr>
	<tr>
		<td>照片上传</td>
		<td><sf:hidden path="url" value="${album.url }"/>
            <input type="file" name="myImage" id="myImage"/>
            <input id="buttonUpload" type="button" value="上传" onclick = "ajaxFileUpload();" />
        </td>
	</tr>
	<tr><td>
			<div class="images-wrap not show" >
				<img id="loading"  src="<%=request.getContextPath() %>/images/load/${album.url }" class="product-image" width="200px" height="200px"/>
			</div>
	</td></tr>
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
//将图片先上传到服务器 
function ajaxFileUpload()  
    {  
    	$.ajaxFileUpload({  
                 url:'<%=request.getContextPath() %>/demo/album/addImage',//需要链接到服务器地址  
                 secureuri:false,  
                 fileElementId:'myImage',                         //文件选择框的id属性  
                 dataType: 'json',                                     //服务器返回的格式，可以是json  
                 success:function (data)              //相当于java中try语句块的用法  
                 {	alert('上传成功 ');
                 	//alert("data:"+data);//console.log(data);
                    if(data!= null){  
                        document.getElementById("url").value = data;
                        document.getElementById("loading").src = "<%=request.getContextPath() %>/images/load/"+data;  
                    }
                 },
                 error:function()             //相当于java中catch语句块的用法  
                 {  alert('上传图片失败');
                 }
       }); 
}
function checkAlbum(){
	var picture_name=document.getElementById("picture_name").value;  
	var description=document.getElementById("description").value;
	var url=document.getElementById("url").value;
	if(picture_name==""){  
	     alert("亲，给图片起个名字吧！"); 
	     return false;
	}else if(url=="1.jpg"){
		alert("亲，上传个图片吧 ！"); 
	    return false;
	}else{
		var patrn1=/^[\u4e00-\u9fa5]{1,10}$/;
	     var patrn2=/^\S{0,255}$/;
	     if (!patrn1.exec(picture_name)){
	        alert("名称为1至10个汉字");
	        //name.focus();
	        return false;
	     }else if(!patrn2.exec(description)){  
		     alert("描述输入内容过多 ");
		     return false;
		 }else{
			 alert('相册更新成功！');
		     return true;
		}
	}
}
</script>
</body>
</html>