//验证用户名密码是否为空
function checkLogin(){
	var name=document.getElementById("name").value;
	var password=document.getElementById("password").value;
	if(name==""||password==""){  
	     alert("不能为空");  
	     return false;  
	}else{  
		 var patrn1=/^[\u4e00-\u9fa5]{1,10}$/;
	     var patrn2=/^\S{0,32}$/;
	     if(!patrn1.exec(name)){
		     alert("名称为1至10个汉字");
		     return false;
		 }else if(!patrn2.exec(password)){  
			 alert("密码长度请少于32个字节 ");
			 return false;
		 }
	     return true;
	}
}
