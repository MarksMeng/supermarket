<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
	<head>
		<title>AddSell_do.jsp</title>
		<script LANGUAGE="javascript">
		<!--
				function checkNum(){
				var num=addnumForm.num.value;
				var cargo=addnumForm.storage_num.value;
				if(parseInt(num)>parseInt(cargo)){
					alert("没有那么多的库存，请重新输入！");
					addnumForm.num.foucs();
					return false;
				}else{

					addnumForm.action="AddSell_Num";

				}
			}
		-->
		</script>
		<style type="text/css">
			<!--
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
			<h1>超市管理系统————————增加上架商品</h1>
			<br>
			<form name="addnumForm" action="" method="post">
				<table style="background-color: antiquewhite">
					<c:forEach var="list" items="${list}">
						<tr class="cargotr">
							<td>商品编号：${list.cargo_id }</td>
						</tr>
						<tr class="cargotr">
							<td>在架数量：${list.sell_num }</td>
						</tr>
						<tr class="cargotr">
							<td>
								上架价格：<input type="text" name="price" value="${list.sell_price }">
							</td>
						</tr>
						<tr class="cargotr">
							<td>
								上架数量：<input type="text" name="num" value="0">
							</td>
						</tr>
						<tr class="cargotr">
							<td>库存数量：${list.storage_num}</td>
						</tr>
						<input name="sell_num" type="hidden" value=${list.sell_num }>
						<input name="cargo_id" type="hidden" value=${list.cargo_id }>
						<input name="storage_num" type="hidden" value=${list.storage_num }>
					</c:forEach>
					<tr>
						<td colspan="2">
							<input type="submit" value="确定" onclick="checkNum()">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="取消">
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
