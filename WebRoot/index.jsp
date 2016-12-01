<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
	<title>欢迎光临</title>
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="refresh" content="2;URL=/javaee_exam1/showgoods" content="text/html; charset=utf-8">
		<style> 
			#rcorners1 {
			    border-radius:50px;
			    background: #9c2e41;
			    padding: 20px; 
			    width: 100px;
			    height: 100px;    
			}
		</style>
	</head>
	<body>
		<center><h1 id="rcorners1">欢</h1></center>
		<center><h1 id="rcorners1">迎</h1></center>
		<center><h1 id="rcorners1">光</h1></center>
		<center><h1 id="rcorners1">临</h1></center>
	</body>
</html>