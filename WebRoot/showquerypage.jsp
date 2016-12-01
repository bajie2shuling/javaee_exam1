<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>商品销量</title>
    <link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>			
    <s:if test="#session.admin!=null">
		<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
		    <tr style="background-color:#9c2e41;">
	    	   	<td><a href="/javaee_exam1/showgoods">商城首页</a></td>
		    	<td><a href="/javaee_exam1/goodsmanage">商品管理</a></td>
		    	<td><a href="/javaee_exam1/seeallorders">订单管理</a></td>
		    	<td><a href="/javaee_exam1/showusers">用户管理</a></td>
		    	<td><a href="/javaee_exam1/logout?type=admin">注销</a></td>
		    	<td><marquee><font style="color: #00ff00">管理员：${sessionScope.admin.adminId }</font></marquee></td>
			</tr>
	    </table>><hr>

		 <form action="expensecondition" method="post">
			    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
					<tr style="background-color:#f1e0b3;">
					<td colspan="3">查询用户消费情况</td>
					</tr>
					<tr style="background-color:#d9f1f2;">
			    		<td>用户名</td>
			    		<td>时间</td>
			    		<td>查询</td>
		    		</tr>
			    	<tr style="background-color:#9c2e41;">
			    		<td >
			    			<input type="text" name="user.userId"  value="${requestScope.user.userId}" readonly="readonly" />
			    		</td>
			    		<td >
			    			<input type="text" name="time"  />
			    		</td>
			    		<td >
			    			<input type="submit" value="查询"/>
			    		</td>
			    	</tr>
			    </table>
		 </form> 
    </s:if>
  </body>
</html>