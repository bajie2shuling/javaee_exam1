<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>购物车</title>
    <link rel="stylesheet" type="text/css" href="css/my.css">
  </head>
  
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>			
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
	    		<td colspan="7" align="center">您的购物车有下列商品</td>
	    	</tr>
	    	<tr style="background-color:#d9f1f2;">
	    		<td>商品编号</td>
	    		<td>商品名称</td>
	    		<td>商品价格（￥）</td>
	    		<td>商品数量</td>
	    		<td>增加</td>
	    		<td>减少</td>
	    		<td>移除</td>
    		</tr>
	   
	    <s:set var="sumPrice" value="0"  />								
		<s:iterator id="scarItem" value="#session.scar" status="st">
			<s:if test="#st.odd==true">
				<tr style="background-color:#f1e0b3;">						  
					<td>								
						<s:property value="value.goods.goodsId"/>
					</td>
					<td>
						<s:property value="value.goods.goodsName"/>
					</td>
					<td>
						<s:property value="value.goods.goodsPrice"/>
					</td>
					<td>								
						<s:property value="value.num"/>
					</td>
					<td>
						<a href="/javaee_exam1/additemnum?goods.goodsId=${value.goods.goodsId}"> + </a>
					</td>
					<td>
						<a href="/javaee_exam1/reduceitemnum?goods.goodsId=${value.goods.goodsId}"> - </a>
					</td>
					<td>
						<a href="/javaee_exam1/deleteitem?goods.goodsId=${value.goods.goodsId}">移除</a>							
					</td>
				</tr>
			</s:if>
			<s:else>
				<tr style="background-color:#d9f1f2;">						  
					<td>								
						<s:property value="value.goods.goodsId"/>
					</td>
					<td>
						<s:property value="value.goods.goodsName"/>
					</td>
					<td>
						<s:property value="value.goods.goodsPrice"/>
					</td>
					<td>								
						<s:property value="value.num"/>
					</td>
					<td>
						<a href="/javaee_exam1/additemnum?goods.goodsId=${value.goods.goodsId}"> + </a>
					</td>
					<td>
						<a href="/javaee_exam1/reduceitemnum?goods.goodsId=${value.goods.goodsId}"> - </a>
					</td>
					<td>
						<a href="/javaee_exam1/deleteitem?goods.goodsId=${value.goods.goodsId}">移除</a>							
					</td>
				</tr>
    		</s:else>
		<s:set var="sumPrice" value="#sumPrice+value.num*value.goods.goodsPrice" />						    			
		</s:iterator>
			<tr style="background-color:#9c2e41;">
	    		<td>合计</td>
	    		<td> - </td>
	    		<td> - </td>
	    		<td> - </td>
	    		<td> - </td>
	    		<td>
	    			￥：<s:property value="#sumPrice"  /> 
					<s:set var="sumPrice" value="#sumPrice" scope="session" />
				</td>
	    		<td> - </td>
    		</tr>
    	</table>
    	 
    	<table width="60%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#9c2e41;">
				<td>
					<a href="/javaee_exam1/clearcar">清空购物车</a>
				</td>
				<td>
					<a href="/javaee_exam1/showgoods">继续购物</a>
				</td>
				<td>
					<a href="/javaee_exam1/addorder">生成订单</a>
				</td>
	    	</tr>
	    </table> 	
    </s:if>
  </body>
</html>
