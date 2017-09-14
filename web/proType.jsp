<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
  <head>
    <title>供应商类型表</title>
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
	  <br />
	  <h1 align="center">超市管理系统————————供应商类型列表</h1>
	  <br />
	  <br />
	  <hr>
	  <table align="center">
		  <tr class="cargoth">
			  <th align="center">分类</th>
			  <th align="center">命令</th>
		  </tr>
		  <c:forEach var="list" items="${list}">
			  <tr class="cargotr">
				  <td>${list.cargo_Type }</td>
				  <td>
					  <a href="proTypeView?type=${list.cargo_Type}" ><font color="green">显示该类供应商</font></a>
					  <a href="deleteProType?id=${list.pro_Id}"><font color="green">删除 </font></a>
				  </td>
			  </tr>
		  </c:forEach>
	  </table>
  </body>
</html>
