<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商城首页</title>
  </head>
  
  <body>
    <%@taglib prefix="s" uri="/struts-tags"%>			<!-- 用户登录后的首页 -->
    <s:if test="#session.user!=null">
		<div align="center">
    	    |<a href="/javaee_exam1/showgoods">商城首页</a>
	    	|<a href="modifyInfo.jsp?role=user">修改个人信息</a>
	    	|<a href="showcar.jsp">我的购物车</a>
	    	|<a href="">我的订单</a>
	    	|<a href="/javaee_exam1/logout?type=user">注销</a>
	    	|
			<font style="color: red">欢迎您：${sessionScope.user.userId}</font>
	    </div><hr>
	    
	    <form action="showgoods" method="post">
		    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
		    	<tr style="background-color:#9c2e41;">
		    		<td align="right" style="width:320px;">
		    			输入商品名
		    		</td>
		    		<td align="left">
		    			<input type="text" name="goods.goodsName" style="width:220px;" />
		    		</td>
		    		<td align="left">
		    			<input type="submit" value="查询"/>
		    		</td>
		    	</tr>
		    </table>
    	</form>
	    
	    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#d9f1f2;">
	    		<td>商品名</td>
	    		<td>商品价格（￥）</td>
	    		<td>购买</td>
	    	</tr>
	    	
	    	<!-- 迭代商品 -->
	    	<s:iterator id="goodsItem" value="#request.goodsList" status="st">
	    		<s:if test="#st.odd==true">
	    			<tr style="background-color:#f1e0b3;">
	    				<td><s:property value="goodsName" /></td>
	    				<td><s:property value="goodsPrice" /></td>
	    				<td><a href="/javaee_exam1/addtoscar?goods.goodsId=${goodsItem.goodsId}">加入购物车</a></td>
	    			</tr>
	    		</s:if>	
	    		<s:else>
	    			<tr style="background-color:#d9f1f2;">
	    				<td><s:property value="goodsName" /></td>
	    				<td><s:property value="goodsPrice" /></td>
	    				<td><a href="/javaee_exam1/addtoscar?goods.goodsId=${goodsItem.goodsId}">加入购物车</a></td>
	    			</tr>
	    		</s:else>
	    	</s:iterator>
	    	<!-- 迭代商品结束 -->
		</table>
    </s:if>
    <s:elseif test="#session.admin!=null">			<!-- 管理员登陆后的首页 -->
    	<div align="center">
    	    |<a href="/javaee_exam1/showgoods">商城首页</a>
	    	|<a href="modifyInfo.jsp?role=admin">修改个人信息</a>
	    	|<a href="/javaee_exam1/goodsmanage">商品管理</a>
	    	|<a href="">用户管理</a>
	    	|<a href="">订单管理</a>
	    	|<a href="/javaee_exam1/logout?type=admin">注销</a>
	    	|
			<font style="color: red">管理员：${sessionScope.admin.adminId }</font>
	    </div><hr>
	    
	    <form action="showgoods" method="post">
		    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
		    	<tr style="background-color:#9c2e41;">
		    		<td align="right" style="width:320px;">
		    			输入商品名
		    		</td>
		    		<td align="left">
		    			<input type="text" name="goods.goodsName" style="width:220px;"/>
		    		</td>
		    		<td align="left">
		    			<input type="submit" value="查询"/>
		    		</td>
		    	</tr>
		    </table>
    	</form>
    	
	    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#d9f1f2;">
	    		<td>商品名</td>
	    		<td>商品价格（￥）</td>
	    	</tr>
	    	
	    	<!-- 迭代商品 -->
	    	<s:iterator id="goodsItem" value="#request.goodsList" status="st">
	    		<s:if test="#st.odd==true">
	    			<tr style="background-color:#f1e0b3;">
	    				<td><s:property value="goodsName" /></td>
	    				<td><s:property value="goodsPrice" /></td>
	    			</tr>
	    		</s:if>	
	    		<s:else>
	    			<tr style="background-color:#d9f1f2;">
	    				<td><s:property value="goodsName" /></td>
	    				<td><s:property value="goodsPrice" /></td>
	    			</tr>
	    		</s:else>
	    	</s:iterator>
	    	<!-- 迭代商品结束 -->
		</table>
    </s:elseif>
    <s:else>											<!-- 默认首页 -->
	    <div align="center">			
	    	|<a href="/javaee_exam1/showgoods">商城首页</a>
	    	|<a href="login.jsp?role=user">用户登录</a>
	    	|<a href="register.jsp?role=user">用户注册</a>
	    	|<a href="login.jsp?role=admin">管理员登录</a>
	    	|<a href="register.jsp?role=admin">管理员注册</a>
	    </div><hr>
	    
	    <form action="showgoods" method="post">
		    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
		    	<tr style="background-color:#9c2e41;">
		    		<td align="right" style="width:320px;">
		    			输入商品名
		    		</td>
		    		<td align="left">
		    			<input type="text" name="goods.goodsName" style="width:220px;" />
		    		</td>
		    		<td align="left">
		    			<input type="submit" value="查询"/>
		    		</td>
		    	</tr>
		    </table>
    	</form>
	    
	    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	<tr style="background-color:#d9f1f2;">
	    		<td>商品名</td>
	    		<td>商品价格（￥）</td>
	    		<td>购买</td>
	    	</tr>
	    	
	    	<!-- 迭代商品 -->
	    	<s:iterator id="goodsItem" value="#request.goodsList" status="st">
	    		<s:if test="#st.odd==true">
	    			<tr style="background-color:#f1e0b3;">
	    				<td><s:property value="goodsName" /></td>
	    				<td><s:property value="goodsPrice" /></td>
	    				<td><a href="login.jsp?role=user">加入购物车</a></td>
	    			</tr>
	    		</s:if>	
	    		<s:else>
	    			<tr style="background-color:#d9f1f2;">
	    				<td><s:property value="goodsName" /></td>
	    				<td><s:property value="goodsPrice" /></td>
	    				<td><a href="login.jsp?role=user">加入购物车</a></td>
	    			</tr>
	    		</s:else>
	    	</s:iterator>
	    	<!-- 迭代商品结束 -->
		</table>
    </s:else>
  </body>
</html>
