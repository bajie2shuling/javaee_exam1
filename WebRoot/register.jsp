<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>欢迎注册</title>
    <link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
     <%@taglib prefix="s" uri="/struts-tags"%>

    <s:if test="#parameters.role[0]=='user'">
	    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
    	    <tr style="background-color:#9c2e41;">
		    	<td><a href="/javaee_exam1/showgoods">商城首页</a></td>
		    	<td><a href="login.jsp?role=user">用户登录</a></td>
		    	<td><a href="login.jsp?role=admin">管理员登录</a></td>
		    	<td><a href="register.jsp?role=admin">管理员注册</a></td>
		    	<td><marquee><font style="color: #00ff00">欢迎光临mallbywjz！</font></marquee></td>
	    	</tr>
    	</table><hr>
	    
	    <form action="register?type=user" method="post" >
    	<table width="20%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
	    		<td><font style="color: #ff8040"><h3>用户注册</h3></font></td>
	    	</tr>
			<tr>
		    	<td><input type="text" name="userId" placeholder="用户名" /></td>
		    </tr>
		    <tr>
		    	<td><input type="password" name="upwd" placeholder="密    码" /></td>
		    </tr>
		    <tr style="background-color:#9c2e41;">
		    	<td><input type="submit" value="注册" /></td>
		    </tr>
	    </table>
	    </form>
    </s:if>
    <s:if test="#parameters.role[0]=='admin'">
	     <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
    	    <tr style="background-color:#9c2e41;">
			    <td><a href="/javaee_exam1/showgoods">商城首页</a></td>
			    <td><a href="login.jsp?role=admin">管理员登录</a></td>
			    <td><a href="login.jsp?role=user">用户登录</a></td>
			    <td><a href="register.jsp?role=user">用户注册</a></td>
			    <td><marquee><font style="color: #00ff00">欢迎光临mallbywjz！</font></marquee></td>
		    </tr>
	    </table><hr>
	    
	    <form action="register?type=admin" method="post" >
    	<table width="20%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
	    		<td><font style="color:#ff8040"><h3>管理员注册</h3></font></td>
	    	</tr>
			<tr>
		    	<td><input type="text" name="adminId" placeholder="管理员名" /></td>
		    </tr>
		    <tr>
		    	<td><input type="password" name="apwd" placeholder="密    码" /></td>
		    </tr>
		    <tr style="background-color:#9c2e41;">
		    	<td><input type="submit" value="注册" /></td>
		    </tr>
	    </table>
	    </form>
    </s:if>
  </body>
</html>
