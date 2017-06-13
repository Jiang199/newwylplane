<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'order2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
						<div class="row clearfix">
							<div class="col-md-1 column">
							</div>
							<div class="col-md-10 column"><br>
								<h1 style="color:#7B7B7B;" class="text-center">
											航 空 售 票 系 统
								</h1><br>
							</div>
							<div class="col-md-1 column">
								<li class="dropdown pull-right" style="list-style:none">
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
							</div>
						</div>
					</div>
				</div>
				<hr style=" height:2px;border:none;border-top:2px dotted #185598;" />
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="row clearfix">
							<div class="col-md-12 column">
								<div class="row clearfix">
									<div class="col-md-1 column">
									
									</div>
									<div class="col-md-10 column">
										<div class="row clearfix">
											<div class="col-md-1 column">
												<img style="height: 60px;width: 80px;" src="images/index4.jpg" class="img-rounded">
											</div>
											<form action="${pageContext.request.contextPath }/searchflight" action="post">	
												<div class="col-md-10 column">
													<div class="row clearfix">
														<div class="col-md-4 column" >
														     &nbsp;&nbsp;
														     <div class="input-group input-group" style="margin-left: 9px;">
		            											<span class="input-group-addon">出发地</span>
		            											<input type="text" name="start" class="form-control" style="width: 140px;" placeholder="北京">
		        											</div>
														</div>
														<div class="col-md-4 column">&nbsp;&nbsp;
															<div class="input-group input-group" style="margin-left: 9px;" >
		            											<span class="input-group-addon">目的地</span>
		            											<input type="text" name="end" class="form-control" style="width: 140px;" placeholder="南京">
		        											</div>
														</div>
														<div class="col-md-4 column">
															&nbsp;&nbsp;
														     <div class="input-group input-group" style="margin-left: 9px;">
		            											<span class="input-group-addon">时间</span>
		            											<input type="text" class="form-control" style="width: 140px;" placeholder="2017-1-1">
		        											</div>
														</div>
													</div>
												</div>
												<div class="col-md-1 column">&nbsp;&nbsp;
													 <button type="submit" class="btn btn-info">查询</button>
												</div>
											</form>
										</div>
									</div>
									
									<div class="col-md-1 column">
									
									</div>
								</div>
								<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
							</div>
						</div>
						
						<br>
						<div class="row clearfix">
							<div class="col-md-12 column">
								<div class="row clearfix">
									<div class="col-md-1 column">
									</div>
									<div class="col-md-10 column">
									<table class="table">
										<thead>
											<tr>
											    <th>航班号</th>
											    <th>出发地</th>
											    <th>目的地</th>
											    <th>出发时间</th>
											    <th>到达时间</th>
											    <th>余票</th>
											    <th>票价</th>
											    <th>航空公司</th>
											    <th>预定</th>
											   
											 </tr>
										</thead>
									<c:forEach items="${allflight}" var="entity1"> 
										<tbody>
											<tr class="info">
											<td>${entity1.flightid }</td>
											<td>${entity1.start }</td>
											<td>${entity1.end }</td>
											<td>${entity1.flytime }</td>
											<td>${entity1.arrivetime }</td>
											<td>${entity1.restseat }</td>
											<td>${entity1.price }</td>
											<td>${entity1.company}</td>
											<td>
												<a href="servletbuy?userid=<%=session.getAttribute("user")%>&flightid=${entity1.flightid}">预定</a>
											</td>
										</tr>	
											
										</c:forEach>
										</tbody>
									</table>
									</div>
									<div class="col-md-1 column">
									</div>
								</div>
							</div>
						</div>
						<br><br><br><br><br><br><br><br>
						<div class="row clearfix">
							<div class="col-md-12 column">
								<div class="row clearfix">
									<div class="col-md-1 column">
									</div>
									<div class="col-md-10 column">
										 <address class="text-center" style="position:absolute;bottom: 0;width: 100%;height: 60px;/*脚部的高度*/ background: #FFF;clear:both;"> <strong>南京邮电大学浪人俱乐部</strong><br /> 桃园24栋<br /> <abbr title="Phone">P:</abbr> 18061621006</address>
									</div>
									<div class="col-md-1 column">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
  </body>
</html>
