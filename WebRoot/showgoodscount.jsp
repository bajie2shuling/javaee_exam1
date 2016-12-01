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
	    </table><hr>
	    <table width="60%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
	    		<td colspan="7" align="center">商品销量情况</td>
	    	</tr>
	    	<tr style="background-color:#d9f1f2;">
	    		<td>商品编号</td>
	    		<td>商品编号</td>
	    		<td>商品销量</td>
    		</tr>

			<tr style="background-color:#f1e0b3;">						  
				<td>${requestScope.goods.goodsId}</td>
   				<td>${requestScope.goods.goodsName}</td>
   				<td>${requestScope.goodsCount}</td>
			</tr>
    	</table>
    </s:if>
  </body>
</html>