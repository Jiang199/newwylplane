<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <script language="javascript" src="js/register.js" type="text/javascript" charset="utf-8"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/RSA.js"></script>
	<script type="text/javascript" src="js/BigInt.js"></script>
	<script type="text/javascript" src="js/Barrett.js"></script>
	<script type="text/javascript" src="js/jQuery.md5.js"></script>
	
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
	<script language="javascript" src="js/register.js" type="text/javascript" charset="utf-8"></script>
 	<script type="text/javascript">
 		//$(document).ready(function(e) {  
 			////////////////////////////
   			// $('#searchClick').click();  
		//}); 
		function ckSub(){
		// 密码生成md5
		var pwd = $.md5($("#pwd").val());
		
		// 对md5用rsa加密
		setMaxDigits(130);
		var key  = new RSAKeyPair("${e}","","${m}");
		//在提交数据之前对密码进行加密
		var result = encryptedString(key, pwd);
		//隐藏域的值,随表单提交 后台取值
		$("#pwdRsa").val(result);
		//提交表单
		$("#form").submit();
	}
		function changeCode(){
			//得到图片元素
			var img = document.getElementsByTagName("img")[1];
			//img.setAttribute("src","/day09_00_HttpServletResponse/servlet/demo4");//XML Dom 语法
			img.src = "/wylplane/validatecode?time="+new Date().getTime();
		}
	</script>
  </head>
  
  <body>
		<div class="container" style="background-color: #E0E0E0;">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-1 column">
						</div>
						<div class="col-md-10 column"><br>
							<h1 class="text-info">
								航空系统用户登陆入口
							</h1><br>
						</div>
						<div class="col-md-1 column">
						</div>
					</div>
				</div>
			</div>
			<hr style="border:5 double #987cb9" width="80%" color=#987cb9 size=9>
			<br>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-1 column">
						</div>
						<div class="col-md-10 column">
							<div class="row clearfix">
								<div class="col-md-7 column">
									<img alt="140x140"  style="width: 540px;height: 300px;" src="images/index1.jpg" />
								</div>
								<div class="col-md-5 column" style="background-color: #F0F0F0;height: 300px;">
									<div class="row clearfix">
										<div class="col-md-12 column">
											<h3  class="text-center">
												用户名密码登陆
											</h3><br>
										</div>
									</div>
									<!-- 分割开来便于区分 -->
									<div class="row clearfix" onload="document.userform.id.focus();">
										<div class="col-md-12 column">
											<form name="userform" id="form" method="post" action="userservlet?action=2" onsubmit="return validateForm()">
												<table border="0" align="center" width="450">
													<tr style="height: 40px;">
														<td width="100px"  align="right">用户名:   </td>
														<td  width="200px"><input type="text" style="margin-left: 8px;" class="form-control" name="id" id="id" maxlength="20" class="txt" onblur="namecheck(this,8);" onfocus="change(this);" onkeyup="movefocus();"></td>
														<td width="150px" id="idmessage"></td>
													</tr>
													<tr style="height: 40px;">
														<td width="100px" align="right">密　码:</td>
														<td width="200px"><input type="password" style="margin-left: 8px;" class="form-control" name="password" id="pwd" maxlength="15" class="txt"  />
																			<input id="pwdRsa" name="pwd" type="hidden" value="" />
														</td>
														<td width="150" id="passwordmessage"></td>
													</tr>
													<tr style="height: 40px;">
														<td width="100px" align="right">验证码:</td>
														<td width="200px"><input type="text" style="margin-left: 8px;" class="form-control" name="code" id="password" maxlength="15" class="txt"  onfocus="change(this);"/>
														
														<td width="150" id="passwordmessage"></td>
													</tr>
													<tr style="height: 40px;">
														<td width="100px" align="right"></td>
														<td width="200px"><img src="/wylplane/validatecode" style="margin-left: 10px;" onclick="changeCode()"/><a href="javascript:changeCode()" >换一张</a></td>
														<td width="150" id="passwordmessage"></td>
													</tr>
													
													<tr style="height: 30px;">  
														<td width="100px" align="right"></td>
														<td width="200px" colspan="1" align="center">
															<input type="button" value="登录" onclick="ckSub()"  class="btn btn-default"  style="margin-left: 0;" > &nbsp; &nbsp;   <a href="register.jsp"><input type="button" class="btn btn-default" value="注册"></a>
														</td>
														<td width="150" id="passwordmessage"></td>
													</tr>
													 <%=request.getAttribute("message")%>
												</table>
											</form>
										</div>
									</div>
								<!-- 分割开来便于区分 -->
								</div>
							</div>
						</div>
						<div class="col-md-1 column">
						</div>
					</div>
				</div>
			</div>
			<br><br>
			<HR style="FILTER:alpha(opacity=100,finishopacity=0,style=3)" width="80%"color=#987cb9 SIZE=3>
			<div><a style="text-align: center" href="one.jsp">返回首页</a></div>
			<br/><br/><br/><br/><br/><br/><br/><br/>
		</div>
  </body>
</html>
