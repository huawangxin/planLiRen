<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"  type="text/css"  href="<%=request.getContextPath() %>/common/css/index.css"/>
<title>添加用户</title>
</head>
<body onload="onload()">
<div class="contact" >
<sf:form name="form1" method="post" modelAttribute="user" onsubmit="return checkAll()">
			<ul>
				<li>
					<label>用户名: </label>
					<sf:input path="name" placeholder="请输入用户名" onblur="checkna()"/><span class="tips" id="divname">长度1~30个字符</span>
				</li>
				<li>
					<label>密码：</label>
					<sf:password path="password"  placeholder="请输入你的密码" onBlur="checkpsd1()"/> <span class="tips" id="divpassword1">密码必须由字母和数字组成</span>
				</li>
				<li>
					<label>确认密码：</label>
					<input name="repassword" value="" type="password"  id="repassword" placeholder="请再次输入你的密码" onBlur="checkpsd2()"/><span class="tips" id="divpassword2">两次密码需要相同</span>
				</li>
				<li>
					<label>性别:</label>
					<sf:radiobutton path="gender" value="男" checked="checked"/> 男   
					<sf:radiobutton path="gender" value="女"/>女
				</li>
				<li>
					<label>年龄:</label>
					<sf:input path="age" placeholder="请输入你的年龄" onBlur="checkage()" /><span class="tips" id="divage">请填写真实年龄</span>
				</li>
				<li>
					<label>电话:</label>
					<sf:input path="tel" placeholder="请输入你的电话" onBlur="checktel()" /><span class="tips" id="divtel">请填写电话</span>
				</li>
				<li>
					<label>电子邮箱：</label>
					<sf:input path="email"  placeholder="请输入你的邮箱" onBlur="checkmail()" /><span class="tips" id="divmail">例如110@qq.com</span>
				</li>
			</ul>
			<b class="btn"><input type="submit" value="提交"/>
			<input type="reset" value="取消"/></b>
</sf:form>
</div>
<script type="text/javascript">
function onload(){
	var url=document.getElementById("age").value;
	if(url==0||url=="0"){
		document.getElementById("age").value ="";
	}
	var a ='<%=request.getAttribute("error")%>';
	if(a=='null'||a==""){
		
	}else{
		divname.innerHTML='<font class="tips_false">用户名已被占用！ </font>';
	}
}
//用户名验证
function checkna(){
		na=form1.name.value;
		if(na.length<1||na.length>30){  	
			divname.innerHTML='<font class="tips_false">长度是1-30个字符</font>';
		}else{  
		    divname.innerHTML='<font class="tips_true">输入正确</font>';
		}  
}
//验证密码 
function checkpsd1(){
		psd1=form1.password.value;
		var flagZM=false;
		var flagSZ=false;
		var flagQT=false;
		if(psd1.length<6 || psd1.length>30){
			divpassword1.innerHTML='<font class="tips_false">长度错误</font>';
		}else{
			for(i=0;i<psd1.length;i++){
				if((psd1.charAt(i)>='A'&&psd1.charAt(i)<='Z')||(psd1.charAt(i)>='a'&&psd1.charAt(i)<='z')){
					flagZM=true;
				}else if(psd1.charAt(i)>='0'&&psd1.charAt(i)<='9'){
					flagSZ=true;
				}else{
					flagQT=true;
				}
			}
			if(!flagZM||!flagSZ||flagQT){
				divpassword1.innerHTML='<font class="tips_false">密码必须是字母数字的组合</font>';
			}else{
				divpassword1.innerHTML='<font class="tips_true">输入正确</font>';
			}
		}
}
//验证确认密码 
function checkpsd2(){
	if(form1.password.value!=form1.repassword.value){
		divpassword2.innerHTML='<font class="tips_false">您两次输入的密码不一样</font>';
	}else{
		divpassword2.innerHTML='<font class="tips_true">输入正确</font>';
	}
}
//验证年龄 
function checkage(){
	var age=form1.age.value;
	var patrn4=/^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
	if(!patrn4.exec(age)){  
	    divage.innerHTML='<font class="tips_false">输入错误</font>';
	}else{
		divage.innerHTML='<font class="tips_true">输入正确</font>';
	}
}
//验证电话 
function checktel(){
	var tel=form1.tel.value;
	var patrn5=/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/;
	if(!patrn5.exec(tel)){  
	    divtel.innerHTML='<font class="tips_false">输入错误</font>';
	}else{
		divtel.innerHTML='<font class="tips_true">输入正确</font>';
	}
}
//验证邮箱
function checkmail(){
	var email=form1.email.value;
	var patrn6=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
	if(!patrn6.exec(email)){  
	    divmail.innerHTML='<font class="tips_false">输入错误</font>';
	}else{
		divmail.innerHTML='<font class="tips_true">输入正确</font>';
	}
}
</script>
</body>
</html>
