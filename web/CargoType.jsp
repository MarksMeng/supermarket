<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
  <head>
    <title>商品类型</title>
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
   <center>
	   <br/>
	       <h1>超市管理系统————————商品类型列表</h1>
   </center>
		<br/>
		<br/>
		<hr>
		<br/> 
		<table align="center">
			<tr>
				<th class="cargoth">商品种类</th>
			</tr>
			<c:forEach var="type" items="${array}">
				<tr class="cargotr">
					<td>${type.cargo_type}</td>
				</tr>
			</c:forEach>
		</table>
  </body>
</html>
