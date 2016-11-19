<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人信息修改</title>
  </head>
  
  <body>
     <%@taglib prefix="s" uri="/struts-tags"%>
    <s:if test="#parameters.role[0]=='user'">
    	<div align="center">
	    	|<a href="/javaee_exam1/showgoods">商城首页</a>
	    	|<a href="login.jsp?role=admin">管理员登录</a>
	    	|<a href="register.jsp?role=admin">管理员注册</a>
	    	|
    	</div><hr>
    	
    	<div align="center">
	    	<form action="modifyinfo?type=user" method="post" >
				<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
						<tr style="background-color:#9c2e41;">
							<td colspan="2">
								用户个人信息
							</td>
						</tr>
						<tr align="center" >
							<td align="right" style="width:320px;" >
								用户名：
							</td>
							<td align="left">							    
								<input type="text" name="user.userId" style="width:220px;" value="${sessionScope.user.userId }" readonly="readonly" />									
							</td>
						</tr>
						<tr>
							<td align="right" style="width:320px;">
								新密码：
							</td>
							<td align="left">
								<input type="password" name="user.pwd" style="width:220px;"  />									
							</td>
						</tr>
						<tr style="background-color:#9c2e41;">
								<td colspan="2">
									<input type="submit" value="修改" />
								</td>
						</tr>
	    		</table>
	    	</form>
	    </div>
    </s:if>
    <s:if test="#parameters.role[0]=='admin'">
	    <div align="center">
		    |<a href="/javaee_exam1/showgoods">商城首页</a>
		    |<a href="login.jsp?role=user">用户登录</a>
		    |<a href="register.jsp?role=user">用户注册</a>
		    |
	    </div><hr>
	    
    	
        <div align="center">
	    	<form action="modifyinfo?type=admin" method="post" >
				<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
						<tr style="background-color:#9c2e41;">
							<td colspan="2">
								管理员个人信息
							</td>
						</tr>
						<tr align="center" >
							<td align="right" style="width:320px;" >
								管理员名：
							</td>
							<td align="left">							    
								<input type="text" name="admin.adminId" style="width:220px;" value="${sessionScope.admin.adminId }" readonly="readonly" />									
							</td>
						</tr>
						<tr>
							<td align="right" style="width:320px;">
								新  密  码：
							</td>
							<td align="left">
								<input type="password" name="admin.pwd" style="width:220px;"  />									
							</td>
						</tr>
						<tr style="background-color:#9c2e41;">
								<td colspan="2">
									<input type="submit" value="修改" />
								</td>
						</tr>
	    		</table>
	    	</form>
	    </div>
    </s:if>
  </body>
</html>
