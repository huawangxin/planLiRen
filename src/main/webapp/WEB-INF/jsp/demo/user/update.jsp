<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
</head>
<body onload="onload()">
<sf:form method="post" modelAttribute="user" onsubmit="return checkUser()">
<table>
	<tr>
		<td>用户名: </td>
		<td>${user.name }</td>
	</tr>
	<tr>
		<td>密码:</td>
		<td><sf:input path="password" value="${user.password }"/>
		</td>
	</tr>
	<tr>
		<td>性别:</td>
		<td>
		<sf:radiobutton path="gender" value="男" checked="checked"/> 男   
		<sf:radiobutton path="gender" value="女"/>女
		</td>
	</tr>
	<tr>
		<td>年龄:</td>
		<td><sf:input path="age" value="${user.age }"/>
		</td>
	</tr>
	<tr>
		<td>电话:</td>
		<td><sf:input path="tel" value="${user.tel }"/>
		</td>
	</tr>
	<tr>
		<td>电子邮箱:</td>
		<td><sf:input path="email" value="${user.email }" />
		</td>
	</tr>
	<tr>
		<sf:hidden path="createTime" value="${user.createTime }" />
		<sf:hidden path="id" value="${user.id }" />
		<sf:hidden path="state" value="${user.state }" />
		<sf:hidden path="sort" value="${user.sort }" />
		<sf:hidden path="name" value="${user.name }" />
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
function onload(){
	var url=document.getElementById("age").value;
	if(url==0||url=="0"){
		document.getElementById("age").value ="";
	}
	/**性别单选框 **/
	var sex=${user.gender };
	$("input[name='gender'][value="+sex+"]").attr("checked",true);
	
}
function checkUser(){
	var name=document.getElementById("name").value;  
	var password=document.getElementById("password").value;
	var repassword=document.getElementById("repassword").value;
	var age=document.getElementById("age").value;
	var tel=document.getElementById("tel").value;
	var email=document.getElementById("email").value;
	//设置一个存放比较密码的量 
	var passwordall=password;
	if(name==""||password==""||repassword==""||age==""||tel==""||email==""){  
	     alert("输入框中不能为空！ ");  
	     return false;
	}else{
		var patrn1=/^[\u4e00-\u9fa5]{1,10}$/;
	     var patrn2=/^\S{0,32}$/;
	     var patrn4=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
	     var patrn5=/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
	     var patrn6=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	     if (!patrn1.exec(name)){
	        alert("名称为1至10个汉字");
	        //name.focus();
	        return false;
	     }else if(!patrn2.exec(password)){  
		     alert("密码长度请少于32个字节 ");
		     return false;
		 }else if(!patrn4.exec(age)){  
		     alert("请输入真实年龄");
		     return false;
		 }else if(!patrn5.exec(tel)){  
		     alert("请输入正确电话号码  ");
		     return false;
		 }else if(!patrn6.exec(email)){  
		     alert("请输入合法的邮箱地址 ");
		     return false;
		 }else{
			 alert('恭喜您注册成功！');
		     return true;
		}
	}
}
</script>
</body>
</html>