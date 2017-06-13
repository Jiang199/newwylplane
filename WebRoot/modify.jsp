<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
    <center>
		<font color=bule size=72>机票修改页面</font>
		<hr>
		    <form action="doModServlet" method="post"">
		<table border="1">
		<tr>
		<td>机票ID：</td>
		<td><input name="flightid" value="<%=request.getAttribute("flightid")%>" ></td>
		</tr>
		
		<tr>
		<td>出发地：</td>
		<td><input name="start" value="<%=request.getAttribute("start")  %>" ></td>
		</tr>
		
		<tr>
		<td>目的地：</td>
		<td><input type="text"  name ="end" value="<%=request.getAttribute("end")  %>" ></td>
		</tr>
		
		<tr>
		<td>起飞时间：</td>
		<%--<td><input type="text" name ="flytime" value="<%=request.getAttribute("flytime") %>"></td> --%>
		<td><input type="text" name ="flytime" value="<%=new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) %>"></td>
		</tr>
		
		<tr>
		<td>到达时间：</td>
		<%--<td><input type="text" name="arrivetime" value="<%=request.getAttribute("arrivetime")  %>" ></td> --%>
		<td><input type="text" name ="arrivetime" value="<%=new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) %>"></td>
		</tr>
		
		<tr>
		<td>余票：</td>
		<td><input type="text" name="restseat" value="<%=request.getAttribute("restseat")  %>" ></td>
		</tr>
		
		<tr>
		<td>票价：</td>
		<td><input type="text" name="price" value="<%=request.getAttribute("price")  %>" ></td>
		</tr>
		
		<tr>
		<td>航空公司：</td>
		<td><input type="text" name="company" value="<%=request.getAttribute("company")  %>" ></td>
		</tr>
		
		
		<tr>
		<td colspan="2">
		 <center>
		 <input type="submit" value="提交">
		 <input type="reset" value="重置">
		</center>
		</td>
		</tr>
		</table>
		
		</form>
    
  </body>
</html>
