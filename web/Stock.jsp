<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>
		<title>进货管理</title>
	</head>
	<c:if test="${manager==null}">
  		<c:set value="123" var="login" scope="session" />
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<body style="background-color: #81C2D6;">
		<center>
			<br />
			<h1>超市管理系统————————进货管理</h1>
			<br />
			<br />
			<hr>
			<br />
			<form action="Stock" method="post">
				<table>
					<tr>
						<td>商品编号：</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>商品名称：</td>
						<td><input type="text" name="cargoName"></td>
					</tr>
					<tr>
						<td>商品类型：</td>
						<td><input type="text" name="cargoType"></td>
					</tr>
					<tr>
						<td>进货数量：</td>
						<td><input type="text" name="stockNum"></td>
					</tr>
					<tr>
						<td>进货单价:</td>
						<td><input type="text" name="stockPrice"></td>
					</tr>
					<tr>
						<td>供应商编号:</td>
						<td><input type="text" name="providerID"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="确定">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="StockList">查看进货表单</a>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
