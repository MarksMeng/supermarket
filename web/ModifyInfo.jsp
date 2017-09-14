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
    
    <title>修改员工信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <c:if test="${manager==null}">
	  <c:set value="123" var="login" scope="session" />
	  <c:redirect url="login.jsp"></c:redirect>
  </c:if>
  
  <body style="background-color: #81C2D6;">
	  <div align="center">
		  <br>
		  <h1>超市管理系统————————修改员工信息</h1>
		  <br />
		  <br />
		  <hr>
		  <form action="modify?id=${id}" method="Post">
			<table>
				<tr>
					<td>
						<tr>
							<td align="center">员工姓名:</td>
							<td align="left"><input type="text" name="name" value="${name }"/></td>
						</tr>
						<tr>
							<td align="center">员工性别:</td>
							<td align="left"><input type="text" name="sex" value="${sex }"/></td>
						</tr>
						<tr>
							<td align="center">员工年龄:</td>
							<td align="left"><input type="text" name="age" value="${age }"/></td>
						</tr>
					</td>
					<td>
						<tr>
							<td align="center">工作时间:</td>
							<td align="left"><input type="text" name="time" value="${time }"/></td>
						</tr>
						<tr>
							<td align="center">员工地址:</td>
							<td align="left"><input type="text" name="address" value="${address }"/></td>
						</tr>
						<tr>
							<td align="center">员工电话:</td>
							<td align="left"><input type="text" name="tel" value="${tel }"/></td>
						</tr>
						<tr>
							<td align="center">部门ID:</td>
							<td align="left"><input type="text" name="dep" value="${dep }"/></td>
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
