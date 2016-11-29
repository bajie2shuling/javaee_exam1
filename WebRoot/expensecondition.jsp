<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>商品销量</title>
  </head>
  
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>			
    <s:if test="#session.admin!=null">
		<div align="center">
    	    |<a href="/javaee_exam1/showgoods">商城首页</a>
	    	|<a href="/javaee_exam1/goodsmanage">商品管理</a>
	    	|<a href="/javaee_exam1/seeallorders">订单管理</a>
	    	|<a href="">用户管理</a>
	    	|<a href="/javaee_exam1/logout?type=admin">注销</a>
	    	|
			<font style="color: red">管理员：${sessionScope.admin.adminId}</font>
	    </div><hr>
	    <table width="60%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
	    		<td colspan="7" align="center">用户消费情况</td>
	    	</tr>
	    	<tr style="background-color:#d9f1f2;">
	    		<td>用户名</td>
	    		<td>时间</td>
	    		<td>购买的商品数量</td>
	    		<td>总花销</td>
    		</tr>

			<tr style="background-color:#f1e0b3;">						  
				<td>${requestScope.userId}</td>
   				<td>${requestScope.time}</td>
   				<td>${requestScope.count}</td>
   				<td>${requestScope.totalprice}</td>
			</tr>
    	</table>
    </s:if>
  </body>
</html>