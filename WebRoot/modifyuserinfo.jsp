<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyuserinfo.jsp' starting page</title>
    
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
 			��ӭ:<%=session.getAttribute("user")%>   
 	<%}else {%>
 		����<a href=<%=request.getContextPath() +"/rsaservlet" %>>��¼</a>
		<%} %>
	 <%if(session.isNew()){ %>
 		��ӭ���û�
	 <%}else{ %>
 		��ӭ���û�
 	<%} %>
 	<div style="text-align: center;font-size: 36px;background-color: #FFFFFF;color: blue;">�û���������</div>
    <br/><hr>
    <hr>
   
	    <div id="divpagecontent"> <br/>
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td width="25%"><table width="100%" border="0" cellspacing="0"
							style="margin-top:30px">
							
							<tr>
								<td class="listtitle">�ҵ��ʻ�</td>
							</tr>
							<tr>
								<td ></td>
							</tr>
							<tr>
								<td class="listtd"><img src="images/miniicon.gif" width="9"
									height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="${pageContext.request.contextPath }/finduserbyname">�û���Ϣ�޸�</a></td>
							</tr>
	
							<tr>
								<td class="listtd"><img src="images/miniicon.gif" width="9"
									height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/findOrderByUserId">������ѯ</a>
								</td>
							</tr>
							<tr>
								<td class="listtd"><img src="images/miniicon.gif" width="9"
									height="6" />&nbsp;&nbsp;&nbsp;&nbsp; <a href="${pageContext.request.contextPath }/Logout">�Ñ��˳�</a>
								</td>
							</tr>
						</table></td>
					<td><div style="text-align:right; margin:5px 10px 5px 0px">
							<a href="one.jsp">��ҳ</a>&nbsp;&nbsp;&gt;&nbsp;<a
								href="info.jsp">&nbsp;�ҵ��ʻ�</a>&nbsp;&nbsp;&gt;&nbsp;&nbsp;��ӭ
						</div>
						
						<table cellspacing="0" class="infocontent">
						<br/>
							<tr>
								<td>
									<form action="${pageContext.request.contextPath }/modifyuserservlet" method="post">
										<input type="hidden" name="id" value="${person.name}"/>
										<table width="100%" border="0" cellspacing="2" class="upline">
										
											<tr>
												<td style="text-align:right; width:20%">�û�����</td>
												<td style="width:40%; padding-left:20px">${person.name }</td>
												<td>&nbsp;</td>
											</tr>
											
											<tr>
												<td style="text-align:right">�޸����룺</td>
												<td><input type="password" name="pwd"
													class="textinput" /></td>
												<td><font color="#999999">������������6λ�������ִ�Сд</font></td>
											</tr>
											<tr>
												<td style="text-align:right">�ظ����룺</td>
												<td><input type="password" class="textinput" /></td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td style="text-align:right">�Ա�</td>
												<td style="width:40%; padding-left:20px">${person.sex }</td>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td style="text-align:right">���֤��</td>
												<td style="width:40%; padding-left:20px">${person.identifyid }</td>
											</tr>
	
											<tr>
												<td style="text-align:right">&nbsp;</td>
												<td>&nbsp;</td>
												<td>&nbsp;</td>
											</tr>
										</table>
	
										<p style="text-align:center">
											<input type="submit" src="images/botton_gif_025.gif" border="0">
										</p>
										<p style="text-align:center">&nbsp;</p>
									</form>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	
	<br/><br/><br/><br/><br/><br/><br/>
	
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
