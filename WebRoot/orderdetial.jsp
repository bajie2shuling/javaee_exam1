<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>订单细节</title>
    <link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>			
    <s:if test="#session.admin!=null">
		<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
			<tr style="background-color:#9c2e41;">
	    	    <td><a href="/javaee_exam1/showgoods">商城首页</a>
		    	<td><a href="/javaee_exam1/goodsmanage">商品管理</a>
		    	<td><a href="/javaee_exam1/showusers">用户管理</a>
		    	<td><a href="/javaee_exam1/seeallorders">订单管理</a>
		    	<td><a href="/javaee_exam1/logout?type=admin">注销</a>
				<td><marquee><font style="color: #00ff00">管理员：${sessionScope.admin.adminId }</font></marquee></td>
	   		</tr>
	   </table><hr>
	    <table width="60%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
	    		<td colspan="7" align="center">订单详情</td>
	    	</tr>
	    	<tr style="background-color:#d9f1f2;">
	    		<td>订单编号</td>
	    		<td>详细订单编号</td>
	    		<td>用户名</td>
	    		<td>商品名</td>
	    		<td>商品单价（￥）</td>
	    		<td>商品数量</td>
    		</tr>
	   						
		<s:iterator id="orderDtItem" value="#request.orderDtList" status="st">
			<s:if test="#st.odd==true">
				<tr style="background-color:#f1e0b3;">						  
					<td><s:property value="orders.orderId" /></td>
    				<td><s:property value="orderDetialId" /></td>
    				<td><s:property value="orders.users.userId" /></td>
    				<td><s:property value="goods.goodsName" /></td>
    				<td><s:property value="goodsPrice" /></td>
    				<td><s:property value="goodsCount" /></td>
				</tr>
			</s:if>
			<s:else>
				<tr style="background-color:#d9f1f2;">						  
		    		<td><s:property value="orders.orderId" /></td>
    				<td><s:property value="orderDetialId" /></td>
    				<td><s:property value="orders.users.userId" /></td>
    				<td><s:property value="goods.goodsName" /></td>
    				<td><s:property value="goodsPrice" /></td>
    				<td><s:property value="goodsCount" /></td>
				</tr>
    		</s:else>
    	</s:iterator>
    	</table>
    </s:if>
    <s:if test="#session.user!=null">
		<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
			<tr style="background-color:#9c2e41;">
	    	    <td><a href="/javaee_exam1/showgoods">商城首页</a></td>
		    	<td><a href="/javaee_exam1/userseeorders">我的订单</a></td>
		    	<td><a href="/javaee_exam1/logout?type=user">注销</a></td>
		    	<td><marquee><font style="color: #00ff00">欢迎您：${sessionScope.user.userId}</font></marquee></td>
	    	</tr>
	    </table><hr>
	    <table width="60%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
	    		<td colspan="7" align="center">订单详情</td>
	    	</tr>
	    	<tr style="background-color:#d9f1f2;">
	    		<td>订单编号</td>
	    		<td>详细订单编号</td>
	    		<td>用户名</td>
	    		<td>商品名</td>
	    		<td>商品单价（￥）</td>
	    		<td>商品数量</td>
    		</tr>
	   						
		<s:iterator id="orderDtItem" value="#request.orderDtList" status="st">
			<s:if test="#st.odd==true">
				<tr style="background-color:#f1e0b3;">					  
		    		<td><s:property value="orders.orderId" /></td>
    				<td><s:property value="orderDetialId" /></td>
    				<td><s:property value="orders.users.userId" /></td>
    				<td><s:property value="goods.goodsName" /></td>
    				<td><s:property value="goodsPrice" /></td>
    				<td><s:property value="goodsCount" /></td>
				</tr>
			</s:if>
			<s:else>
				<tr style="background-color:#d9f1f2;">						  
		    		<td><s:property value="orders.orderId" /></td>
    				<td><s:property value="orderDetialId" /></td>
    				<td><s:property value="orders.users.userId" /></td>
    				<td><s:property value="goods.goodsName" /></td>
    				<td><s:property value="goodsPrice" /></td>
    				<td><s:property value="goodsCount" /></td>
				</tr>
    		</s:else>
    	</s:iterator>
    	</table>
    </s:if>
  </body>
</html>