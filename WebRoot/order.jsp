<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>订单处理</title>
    <link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>			
    <s:if test="#session.admin!=null">
		<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
			<tr style="background-color:#9c2e41;">	
	    	    <td><a href="/javaee_exam1/showgoods">商城首页</a></td>
		    	<td><a href="/javaee_exam1/goodsmanage">商品管理</a></td>
		    	<td><a href="/javaee_exam1/showusers">用户管理</a></td>
		    	<td><a href="/javaee_exam1/logout?type=admin">注销</a></td>
				<td><marquee><font style="color: #00ff00">管理员：${sessionScope.admin.adminId }</font></marquee></td>
			</tr>
	    </table><hr>
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
	    		<td>处理订单</td>
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
    				<td><a href="/javaee_exam1/changestate?orders.orderId=${orderItem.orderId}">处理订单</a></td>
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
    				<td><a href="/javaee_exam1/changestate?orders.orderId=${orderItem.orderId}">处理订单</a></td>
				</tr>
    		</s:else>
    	</s:iterator>
    	</table>
    </s:if>
  </body>
</html>