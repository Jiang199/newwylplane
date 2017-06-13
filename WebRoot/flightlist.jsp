<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'flightlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/main.css" type="text/css" />
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
		 	<div style="text-align: center;font-size: 36px;background-color: #FFFFFF;color: blue;">用户管理中心</div>
		    <br/><hr>
		    <hr>
			    <div id="divpagecontent">
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td width="25%"><table width="100%" border="0" cellspacing="0"
									style="margin-top:30px">
									<tr>
										<td class="listtitle">我的帐户</td>
									</tr>
									<tr>
										<td class="listtd"><img src="images/miniicon.gif" width="9"
											height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
											href="${pageContext.request.contextPath }/finduserbyname">用户信息修改</a></td>
									</tr>
			
									<tr>
										<td class="listtd"><img src="images/miniicon.gif" width="9"
											height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/findOrderByUserId">订单查询</a>
										</td>
									</tr>
									<tr>
										<td class="listtd"><img src="images/miniicon.gif" width="9"
											height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/Logout">用戶退出</a>
										</td>
									</tr>
								</table></td>
							<td><div style="text-align:right; margin:5px 10px 5px 0px">
									<a href="one.jsp">首页</a>&nbsp;&nbsp;&gt;&nbsp;<a
										href="info.jsp">&nbsp;我的帐户</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;欢迎
								</div>
								<table cellspacing="0" class="infocontent">
									<tr><br/>
										<td style="padding:20px"><p>欢迎登陆用户中心！</p>
											<p>
												您有<font style="color:#FF0000">${count}</font>个订单
											</p><br/>
												<table width="100%" border="0" cellspacing="0" class="tableopen">
									<tr>
										<td bgcolor="#A3E6DF" class="tableopentd01">航班号</td>
										<td bgcolor="#A3D7E6" class="tableopentd01">出发地</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">目的地</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">起飞时间</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">票价</td>
										<td bgcolor="#A3CCE6" class="tableopentd01">航空公司</td>
										<td bgcolor="#A3E2E6" class="tableopentd01">操作</td>
									</tr>

						<c:forEach items="${flights}" var="order"> 
								
									<tr>
										
										<td class="tableopentd02">${order.flightid }</td>
										<td class="tableopentd02">${order.start }</td>
										<td class="tableopentd02">${order.end }</td>
										<td class="tableopentd02">${order.flytime }</td>
										<td class="tableopentd02">${order.price }</td>
										<td class="tableopentd02">${order.company }</td>
										<td class="tableopentd02"><a href="${pageContext.request.contextPath }/deleteorder?Id=${order.flightid}">退票</a></td>
									</tr>
						</c:forEach>
								</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			
			
			<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><hr>
				<div id="divfoot">
					<table width="100%" border="0" cellspacing="0">
						<tr>
							<td rowspan="2" style="width:10%"><img
								src="images/bottomlogo.gif" width="195" height="50"
								style="margin-left:175px" /></td>
							<td style="padding-top:5px; padding-left:50px"><a href="#"><font
									color="#747556"><b>CONTACT US</b> </font> </a></td>
						</tr>
						<tr>
							<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
										2008 &copy; eShop All Rights RESERVED.</b> </font></td>
						</tr>
					</table>
				</div>
  </body>
</html>
