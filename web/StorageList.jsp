<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>
		<title>库存列表</title>
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
			<br />
			<h1>超市管理系统————————库存列表</h1>
			<br />
			<br />
			<hr>
			<br />
			<table>
				<tr>
					<th class="cargoth">商品编号</th>
					<th class="cargoth">商品名称</th>
					<th class="cargoth">商品类型</th>
					<th class="cargoth">库存数量</th>
					<th class="cargoth">商品上架</th>
				</tr>
				<c:forEach var="storagelist" items="${alist}">
				<tr class="cargotr">
					<td>${storagelist.cargo_id }</td>
					<td>${storagelist.cargo_name }</td>
					<td>${storagelist.cargo_type}</td>
					<td>${storagelist.storage_num }</td>
					<td>
						<a href="AddOnSell?id=${storagelist.cargo_id }">上架</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</html>
