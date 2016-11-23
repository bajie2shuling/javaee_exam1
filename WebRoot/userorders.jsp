<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>用户订单</title>
  </head>
  
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>			
    <s:if test="#session.user!=null">
		<div align="center">
    	    |<a href="/javaee_exam1/showgoods">商城首页</a>
	    	|<a href="">我的订单</a>
	    	|<a href="/javaee_exam1/logout?type=admin">注销</a>
	    	|
			<font style="color: red">欢迎您：${sessionScope.user.userId}</font>
	    </div><hr>
	    <table width="60%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
	    		<td colspan="7" align="center">有如下订单</td>
	    	</tr>
	    	<tr style="background-color:#d9f1f2;">
	    		<td>订单编号</td>
	    		<td>用户名</td>
	    		<td>订单时间</td>
	    		<td>订单状态</td>
	    		<td>订单合计（￥）</td>
	    		<td>查看订单细节</td>
    		</tr>
	   						
		<s:iterator id="orderItem" value="#request.orderList" status="st">
			<s:if test="#st.odd==true">
				<tr style="background-color:#f1e0b3;">						  
					<td><s:property value="orderId" /></td>
    				<td><s:property value="users.userId" /></td>
    				<td><s:date name="orderTime" format="yyyy-MM-dd hh:mm:ss"/></td>
    				<td><s:property value="orderState" /></td>
    				<td><s:property value="orderTotalPrice" /></td>
    				<td><a href="/javaee_exam1/seeorderdt?oid=${orderItem.orderId}">查看订单细节</a></td>
				</tr>
			</s:if>
			<s:else>
				<tr style="background-color:#d9f1f2;">						  
		    		<td><s:property value="orderId" /></td>
    				<td><s:property value="users.userId" /></td>
    				<td><s:date name="orderTime" format="yyyy-MM-dd hh:mm:ss"/></td>
    				<td><s:property value="orderState" /></td>
    				<td><s:property value="orderTotalPrice" /></td>
    				<td><a href="/javaee_exam1/seeorderdt?oid=${orderItem.orderId}">查看订单细节</a></td>
				</tr>
    		</s:else>
    	</s:iterator>
    	</table>
    </s:if>
  </body>
</html>