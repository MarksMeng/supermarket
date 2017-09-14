<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>
		<title>商品进货列表</title>

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
			<h1>超市管理系统————————商品进货列表</h1>
			<br />
			<br />
			<hr>
			<br />
			<table>
				<tr class="cargoth">
					<th>商品编号</th>
					<th>商品名</th>
					<th>商品类型</th>
					<th>进货数量</th>
					<th>进货价格</th>
					<th>进货日期</th>
					<th>供应商编号</th>
					<th>管理员</th>
				</tr>
				<c:forEach var="stock" items="${list}">
				<tr class="cargotr">
					<td>${stock.cargo_id }</td>
					<td>${stock.cargo_name }</td>
					<td>${stock.cargo_type }</td>
					<td>${stock.stock_num }</td>
					<td>${stock.stock_price }</td>
					<td>${stock.stock_date }</td>
					<td>${stock.pro_id }</td>
					<td>${stock.mana_name }</td>
				</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</html>
