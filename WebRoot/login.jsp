<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎登录</title>
  </head>
  
  <body>
     <%@taglib prefix="s" uri="/struts-tags"%>
    <s:if test="#parameters.role[0]=='user'">
    	<div align="center">
	    	|<a href="index.jsp">商城首页</a>
	    	|<a href="register.jsp?role=user">用户注册</a>
	    	|<a href="login.jsp?role=admin">管理员登录</a>
	    	|<a href="register.jsp?role=admin">管理员注册</a>
	    	|
    	</div><hr>
    	
    	<div align="center">
    		<h2>用户登录</h2>
    	</div>
    	
    	<div align="center">
	    	<s:form action="login?type=user" method="post" >
	    		<s:textfield label="用户名" name="userId"/><br><br>	
	    		<s:password label="密　码" name="upwd"/><br><br>
	    		<s:submit  value="登录"/><br>
	    	</s:form>
	    </div>
    </s:if>
    <s:if test="#parameters.role[0]=='admin'">
	    <div align="center">
		    |<a href="index.jsp">商城首页</a>
		    |<a href="register.jsp?role=admin">管理员注册</a>
		    |<a href="login.jsp?role=user">用户登录</a>
		    |<a href="register.jsp?role=user">用户注册</a>
		    |
	    </div><hr>
	    
	    <div align="center">
    		<h2>管理员登录</h2>
    	</div>
    	
        <div align="center">
	    	<s:form action="login?type=admin" method="post" >
	    		<s:textfield label="管理员名" name="adminId"/><br><br>	
	    		<s:password label="密　　码" name="apwd"/><br><br>
	    		<s:submit  value="登录"/><br>
	    	</s:form>
	    </div>
    </s:if>
  </body>
</html>
