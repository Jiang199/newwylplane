<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'one.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/one.css" rel="stylesheet" type="text/css"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
	
	<script>
		function open()
		{
			alert("arg");
		}
	</script>
  </head>
  
  <body>
  <%if(session.getAttribute("user")!=null){%>
 			欢迎:<%=session.getAttribute("user")%>   
 	<%}else {%>
 		请先<a href=<%=request.getContextPath() +"/rsaservlet" %>>登录</a>
		<%} %>
	 <%if(session.isNew()){ %>
 		欢迎新用户
	 <%}else{ %>
 		欢迎老用户
 	<%} %>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="title">
				航空售票系统
			</h3>
		</div>
	</div>
	</br>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="nav nav-tabs">
				<li class="active">
					 <a href="one.jsp">首页</a>
				</li>
				<li>
					 <a href="pageservlet">查票</a>
				</li>
				<li class="disabled">
					 <a href="pageservlet">安全常识</a>
				</li>
				<li class="disabled">
					 <a href="pageservlet">客运服务</a>
				</li>
				<li class="disabled">
					 <a href="pageservlet">信息</a>
				</li>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">用户中心<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 
							 <a href=<%=request.getContextPath() +"/rsaservlet" %>>用户登陆</a>
						</li>
						<li>
							 <a href="register.jsp">用户注册</a>
						</li>
						<li>
							 <a href="${pageContext.request.contextPath}/Info">我的账户</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="Logout">退出</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	</br>
	<div class="row clearfix">
		<div class="col-md-3 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								购票系统
							</h3>
						</div>
						<div class="panel-body" id="register" onclick="open()">
							<a href="register.jsp">购票用户注册</a>
						</div>
						<div class="panel-body">
							<a href="pageservlet">购票</a>
						</div>
						<div class="panel-body">
							<a href="info.jsp">退票</a>
						</div>
						
					
						<div class="panel-footer">
							客服中心：88888888
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-2 control-label">出发地</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPassword3" class="col-sm-2 control-label">目的地</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword3" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">查询</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table">
						<thead>
							<tr>
								<th>
									编号
								</th>
								<th>
									产品
								</th>
								<th>
									交付时间
								</th>
								<th>
									状态
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Default
								</td>
							</tr>
							<tr class="success">
								<td>
									1
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									01/04/2012
								</td>
								<td>
									Approved
								</td>
							</tr>
							<tr class="error">
								<td>
									2
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									02/04/2012
								</td>
								<td>
									Declined
								</td>
							</tr>
							<tr class="warning">
								<td>
									3
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									03/04/2012
								</td>
								<td>
									Pending
								</td>
							</tr>
							<tr class="info">
								<td>
									4
								</td>
								<td>
									TB - Monthly
								</td>
								<td>
									04/04/2012
								</td>
								<td>
									Call in to confirm
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="col-md-3 column">
			<div class="carousel slide" id="carousel-647441">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-647441">
					</li>
					<li data-slide-to="1" data-target="#carousel-647441">
					</li>
					<li data-slide-to="2" data-target="#carousel-647441" class="active">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item">
						<img alt="" src="images/k1.png" />
						<div class="carousel-caption">
							<h4>
								First Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="images/k2.png" />
						<div class="carousel-caption">
							<h4>
								Second Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
					<div class="item active">
						<img alt="" src="images/k3.png" />
						<div class="carousel-caption">
							<h4>
								Third Thumbnail label
							</h4>
							<p>
								Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-647441" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-647441" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div >
			<h3 class="footer">
				。。。。。。。。。。。版权信息。。。。。。。。。。。。。
			</h3>
		</div>
	</div>
</div>
  </body>
</html>
