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
 			��ӭ:<%=session.getAttribute("user")%>   
 	<%}else {%>
 		����<a href=<%=request.getContextPath() +"/rsaservlet" %>>��¼</a>
		<%} %>
	 <%if(session.isNew()){ %>
 		��ӭ���û�
	 <%}else{ %>
 		��ӭ���û�
 	<%} %>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="title">
				������Ʊϵͳ
			</h3>
		</div>
	</div>
	</br>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<ul class="nav nav-tabs">
				<li class="active">
					 <a href="one.jsp">��ҳ</a>
				</li>
				<li>
					 <a href="pageservlet">��Ʊ</a>
				</li>
				<li class="disabled">
					 <a href="pageservlet">��ȫ��ʶ</a>
				</li>
				<li class="disabled">
					 <a href="pageservlet">���˷���</a>
				</li>
				<li class="disabled">
					 <a href="pageservlet">��Ϣ</a>
				</li>
				<li class="dropdown pull-right">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">�û�����<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							 
							 <a href=<%=request.getContextPath() +"/rsaservlet" %>>�û���½</a>
						</li>
						<li>
							 <a href="register.jsp">�û�ע��</a>
						</li>
						<li>
							 <a href="${pageContext.request.contextPath}/Info">�ҵ��˻�</a>
						</li>
						<li class="divider">
						</li>
						<li>
							 <a href="Logout">�˳�</a>
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
								��Ʊϵͳ
							</h3>
						</div>
						<div class="panel-body" id="register" onclick="open()">
							<a href="register.jsp">��Ʊ�û�ע��</a>
						</div>
						<div class="panel-body">
							<a href="pageservlet">��Ʊ</a>
						</div>
						<div class="panel-body">
							<a href="info.jsp">��Ʊ</a>
						</div>
						
					
						<div class="panel-footer">
							�ͷ����ģ�88888888
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
							 <label for="inputEmail3" class="col-sm-2 control-label">������</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3" />
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPassword3" class="col-sm-2 control-label">Ŀ�ĵ�</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword3" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">��ѯ</button>
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
									���
								</th>
								<th>
									��Ʒ
								</th>
								<th>
									����ʱ��
								</th>
								<th>
									״̬
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
				������������������������Ȩ��Ϣ��������������������������
			</h3>
		</div>
	</div>
</div>
  </body>
</html>
