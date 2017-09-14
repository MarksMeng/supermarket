<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript">
    <!--
    function check() {
        if(document.form1.name.value==""){
        window.alert("用户名不能为空!");
            document.form1.name.focus();
            return false;
        }
        if(document.form1.pwd.value==""){
        window.alert("密码不能为空!");
            document.form1.pwd.focus();
            return false;
        }
          return true;
    }
    //-->
    </script>
      <style>
          *{
              padding:0px;
              margin:0px;
          }
          a{color:White}
          body{
              font-family:Arial, Helvetica, sans-serif;
              background:url(/IMG/grass1.jpg) no-repeat  center;
              font-size:13px;
          }
          img{
              border:0;
          }
          .lg{width:468px; height:468px; margin:100px auto; background:url(/IMG/login_bg3.png) no-repeat;}
          .lg_top{ height:200px; width:468px;}
          .lg_main{width:400px; height:180px; margin:0 25px;}
          .lg_m_1{
              width:290px;
              height:100px;
              padding:60px 55px 20px 55px;
          }
          .ur{
              height:37px;
              border:0;
              color:#666;
              width:236px;
              margin:4px 28px;
              background:url(/IMG/user.png) no-repeat;
              padding-left:10px;
              font-size:16pt;
              font-family:Arial, Helvetica, sans-serif;
          }
          .pw{
              height:37px;
              border:0;
              color:#666;
              width:236px;
              margin:4px 28px;
              background:url(/IMG/password.png) no-repeat;
              padding-left:10px;
              font-size:16pt;
              font-family:Arial, Helvetica, sans-serif;
          }
          .bn{width:330px; height:72px; background:url(/IMG/enter.png) no-repeat; border:0; display:block; font-size:18px; color:#FFF; font-family:Arial, Helvetica, sans-serif; font-weight:bolder;}
          .lg_foot{
              height:80px;
              width:330px;
              padding: 6px 68px 0 68px;
          }
      </style>

  </head>
  
  <body class="b">
      <center>
          <div class="lg">
              <form name="form1" action="login" method="post">
                  <div class="lg_top"></div>
                  <div class="lg_main">
                      <div class="lg_m_1">
                          <input name="name" value="username" class="ur" />
                          <input name="pwd" type="password" value="mengzh.xin" class="pw" />
                      </div>
                  </div>
                  <div class="lg_foot">
                      <input type="submit" value="点这里登录" class="bn" onclick="return check()"/>
                  </div>
             </form>

            <c:if test="${!empty login}">
                <script language="JavaScript">
                window.alert("请先登录！");
                </script>
                <c:remove var="login" scope="session"/>
            </c:if>
            <c:if test="${error!=null}">
                <script language="JavaScript">
                window.alert("登录失败！请检查你的用户名和密码！");
                </script>
            </c:if>
          </div>
      </center>
  </body>
</html>
