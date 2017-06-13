<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/register.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script language="javascript" src="js/register.js" type="text/javascript" charset="gb2312"></script>
  	<script type="text/javascript">
  	
    	
  		//判断 输入的用户名是否已经存在
   		 //field为获取用户所填写的用户名  
    	 function validate(field) {  
         	var username = document.getElementById("username").value;
        
       	 	//1.创建ajax对象
        	var xhr = ajaxFunction();
        	xhr.onreadystatechange = function() {
            	//处理后台返回的数据
            	if(xhr.readyState == 4) {
                	if(xhr.status == 200) {
                    	var data= xhr.responseText;
                    	document.getElementById("divcheck").innerHTML = data;
                	}
            	}
        	}
    		//规定发送数据的形式（post/get），url，以及传输方式(同步/异步)
       	 	xhr.open("post","userisexist?timeStamp="+new Date().getTime(),true);
        	//post方式需要加下边这句，get方式不需要
        	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        	//将页面输入数据发送到后台
        	xhr.send("username="+username);
    	}    
    	
    	function ajaxFunction() {
    			var xmlHttp;
    			try {
        			xmlHttp = new XMLHttpRequest();
    			} catch(e) {
        		try {
            		xmlHttp = new ActiveXObject("Msxm12.XMLHTTP");
        		} catch(e) {
           	 	try {
               	 	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            	} catch(e) {}
        	}
        
    		}
    		return xmlHttp;
		}
    	
  	</script>
  </head>
  
  <body> 
    
	 <div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<h3 class="title">
					航空售票系统
				</h3>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li>
						 <a href="one.jsp">首页</a>
					</li>
					<li>
						 <a href="register.jsp">注册</a>
					</li>
					<li class="active">
						正在注册
					</li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column">
					</div>
					<div class="col-md-8 column">
					
						<div style="padding: 50px 100px 10px;">
							<form action="userservlet?action=1" method="post" class="bs-example bs-example-form" 
												 role="form">
								<div class="input-group ">
									<span class="input-group-addon">用户名</span>
									<input type="text"  class="form-control" name="username" id="username" onblur="validate(this)"  placeholder="用户名设置后不可更改">
								</div> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span id="divcheck"></span> <br>
								<div class="input-group">
									<span class="input-group-addon">登陆密码</span>
									<input type="password" class="form-control" id="pwd1" name="password" placeholder="6-20位字母、数字或符号">
								</div><br>
								<div class="input-group ">
									<span class="input-group-addon">确认密码</span>
									<input type="password" class="form-control" id="pwd2" name="repassword"   placeholder="再次输入您的登陆密码">
								</div>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<span id="tishi"></span></br>
								<div class="input-group ">
									<span class="input-group-addon">证件类型</span>
									<button type="button" class="form-control " data-toggle="dropdown">
										二代身份证
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="">港澳通行证</a></li>
										<li><a href="">台湾通行证</a></li>
										<li><a href="">护照</a></li>
									</ul>
								</div></br>
								<div class="input-group ">
									<span class="input-group-addon">身份证号码</span>
									<input type="text" class="form-control" name="identifyid" placeholder="请输入您的证件号码">
								</div></br>
								<div class="input-group ">
									<span class="input-group-addon">年龄</span>
									<input type="text" class="form-control" name="age" placeholder="请输入您的年龄">
								</div>
								</br>
								<div class="input-group ">
									<span class="input-group-addon">性别       </span>		
									<tr>     
							            <td>  
							                <input type="radio" name="sex" value="1"> 男  
							                <input type="radio" name="sex" value="0"> 女  
							            </td>  
							        </tr> 
								</div></br>
								<div class="col-md-12 column">
									 <input type="submit" class="btn btn-default" value="提交" id="submit"/>
								</div>
							</form>
						</div>

					</div>
					<div class="col-md-2 column">
					</div>
				</div>
			</div>
		</div>
	</div>
  </body>
</html>
