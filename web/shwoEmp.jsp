<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>员工信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	  <style type="text/css">
		  <!--
		  .cargoth{
			  background-color: #687FD9;
		  }

		  .cargotr{
			  background-color: #D6DFF7;
		  }

		  body{
			  background-color: #81C2D6;
		  }
		  -->
	  </style>
  </head>
  <c:if test="${manager==null}">
	  <c:set value="123" var="login" scope="session" />
	  <c:redirect url="login.jsp"></c:redirect>
  </c:if>
  <body>
	<div align="center">
		<h1>超市管理系统————————员工信息管理</h1>
		<br>
		<hr>
		<form action="FindServlet" method="Post">
			查找字段:
			<select name="field">
				<option value="Emp_Name">姓名</option>
				<option value="Emp_Sex">性别</option>
				<option value="Emp_Age">年龄</option>
				<option value="Emp_Date">日期</option>
				<option value="Dep_ID">部门</option>
			</select>
			查找方式:
			<select name="method">
				<option value="unlike">精确查找</option>
				<option value="like">模糊查找</option>
			</select>
			<p>
				请输入关键字:<input type="text" name="key"/>
				<input type="submit" value="确定"/>
				<input type="reset" value="取消"/>
			</p>
		</form>
	</div>
	<hr>
	<div align="center">
		<table width="700" border="0" align="center">
			<tr class="cargoth">
				<th align="center">员工ID</th>
				<th align="center">员工姓名</th>
				<th align="center">员工性别</th>
				<th align="center">员工年龄</th>
				<th align="center">工作时间</th>
				<th align="center">员工地址</th>
				<th align="center">员工电话</th>
				<th align="center">部门ID</th>
				<th align="center">编辑操作</th>
			</tr>
			<c:forEach var="list" items="${list}">
			<tr class="cargotr">
				<td align="center">${list.emp_ID}</td>
				<td align="center">${list.emp_Name }</td>
				<td align="center">${list.emp_Sex}</td>
				<td align="center">${list.emp_Age }</td>
				<td align="center">${list.emp_Date }</td>
				<td align="center">${list.emp_Address }</td>
				<td align="center">${list.emp_Tel }</td>
				<td align="center">${list.dep_ID }</td>
				<td align="center"><a href="DeleCheck?Emp_ID=${list.emp_ID}">删除</a>&nbsp;&nbsp;<a href="CheckServlet?Emp_ID=${list.emp_ID }">修改</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<div align="center">
		<hr>
		<form action="AddServlet" method="post">
			<caption align="center"><h2>增加员工</h2></caption>
			<hr>
			<table>
				<tr>
					<td>
						<tr>
							<td align="center">员工姓名:</td>
							<td align="left"><input type="text" name="name"/></td>
						</tr>
						<tr>
							<td align="center">员工性别:</td>
							<td align="left"><input type="text" name="sex"/></td>
						</tr>
						<tr>
							<td align="center">员工年龄:</td>
							<td align="left"><input type="text" name="age"/></td>
						</tr>
						<tr>
							<td align="center">部门ID:</td>
							<td align="left"><input type="text" name="dep"/></td>
						</tr>
					</td>
					<td>
						<tr>
							<td align="center">工作时间:</td>
							<td align="left"><input type="text" name="time"/></td>
						</tr>
						<tr>
							<td align="center">员工地址:</td>
							<td align="left"><input type="text" name="address"/></td>
						</tr>
						<tr>
							<td align="center">员工电话:</td>
							<td align="left"><input type="text" name="tel"/></td>
						</tr>
					</td>
				</tr>
				<tr>
					<td align="right"><input type="submit" value="提交"/></td>
					<td align="center"><input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
	</div>
  </body>
</html>
