<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.plane.entity.*" %>
<%@ page import="com.plane.impdao.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
	
 	<hr size="2px;" style="color: red;">
	<br/>
	
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-1 column">
					</div>
					<div class="col-md-10 column">
						<h3 class="title">
							飞机票信息如下
						</h3>
					</div>
					<br/><hr style="color: green;size: 2px;" color="red"><br/><br/>
					<div class="col-md-1 column">
					</div>
				</div>
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
							<%
								flightdaoimp dao = new flightdaoimp();
								List<flightentity> flights = dao.findAllFlight();
								for (flightentity entity1 : flights) {
							%>
							<tbody>
								<tr class="info">
								<td><%=entity1.getFlightid()%></td>
								<td><%=entity1.getStart()%></td>
								<td><%=entity1.getEnd()%></td>
								
								<td><%=entity1.getFlytime()%></td>
								<td><%=entity1.getArrivetime()%></td>
								<td><%=entity1.getRestseat()%></td>
								<td><%=entity1.getPrice()%></td>
								<td><%=entity1.getCompany()%></td>
								<td>
									<a href="servletbuy?userid=<%=session.getAttribute("user")%>">预定</a>
								</td>
							</tr>	
								
								<%
									}
								%>
							</tbody>
						</table>
					</div>
					<div class="col-md-1 column">
					</div>
				</div>
			</div>
		</div>
	</div>

  </body>
</html>
