<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.plane.entity.userentity"%>
<%@page import="com.plane.entity.flightentity"%>
<%@page import="com.plane.impdao.flightdaoimp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>航空管理系统</title>
    
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
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.css" rel="stylesheet">
	<link href="//cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">

  </head>
  
  <body>
 
  <%if(session.getAttribute("admin")!=null){%>
  			<% userentity admin =new userentity(); admin = (userentity)session.getAttribute("admin");System.out.println("fasjdfkasd////"+admin.getName()); %>
 			管理员:<%=admin.getName()%> 在线
 	<%}else {%>
 		请先<a href=<%=request.getContextPath() +"/rsaservlet" %>>登录</a>
 		
		<%} %>
	 <%if(session.isNew()){ %>
 		
	 <%}else{ %>
 		
 	<%} %>
   <br>
   <hr>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-1 column">
				</div>
				<div class="col-md-10 column">
					<h3 class="text-center text-info" style="font-size: 40px;">
						管理员后台<br/><br/>
					</h3>
				</div>
				<div class="col-md-1 column">
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-6 column">
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <button type="button" class="btn btn-default btn-info" style="text-align: center"><a href="${pageContext.request.contextPath}/selectallflights">查询所有航线</a></button>
				</div>
				<div class="col-md-6 column">
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <button type="button" class="btn btn-default btn-warning" style="text-align: center">插入新的航班</button>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-1 column">
						</div>
						<div class="col-md-10 column">
							
						</div>
						<div class="col-md-1 column">
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-1 column">
				</div>
				<div class="col-md-10 column">
				</div>
				<div class="col-md-1 column">
				</div>
			</div>
		</div>
  </body>
</html>
