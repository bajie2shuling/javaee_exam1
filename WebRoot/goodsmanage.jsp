<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理商品</title>
  </head>
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>
		<s:if test="#session.admin!=null">
			<div align="center">
	    	    |<a href="index.jsp">商城首页</a>
		    	|<a href="modifyInfo.jsp?role=admin">修改个人信息</a>
		    	|<a href="addgoods.jsp">添加商品</a>
		    	|<a href="">用户管理</a>
		    	|<a href="">订单管理</a>
		    	|<a href="/javaee_exam1/logout?type=admin">注销</a>
		    	|&nbsp;&nbsp; &nbsp;&nbsp;
				<font style="color: red">管理员：${sessionScope.admin.adminId }</font>
		    </div><hr>
		    
		    <form action="goodsmanage" method="post">
			    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
			    	<tr style="background-color:#9c2e41;">
			    		<td align="right" style="width:320px;">
			    			输入商品名
			    		</td>
			    		<td align="left">
			    			<input type="text" name="goods.goodsName" style="width:220px;" value="${requestScope.goodsName} " />
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
		    		<td>修改</td>
		    		<td>删除</td>
		    	</tr>
		    	
		    	<!-- 迭代商品 -->
		    	<s:iterator id="goodsItem" value="#request.goodsList" status="st">
		    		<s:if test="#st.odd==true">
		    			<tr style="background-color:#f1e0b3;">
		    				<td><s:property value="goodsName" /></td>
		    				<td><s:property value="goodsPrice" /></td>
		    				<td><a href="/javaee_exam1/updategoods?goods.goodsId=${goodsItem.goodsId} }">修改</a></td>
		    				<td><a href="/javaee_exam1/deletegoods?goods.goodsId=${goodsItem.goodsId} }">删除</a></td>
		    			</tr>
		    		</s:if>	
		    		<s:else>
		    			<tr style="background-color:#d9f1f2;">
		    				<td><s:property value="goodsName" /></td>
		    				<td><s:property value="goodsPrice" /></td>
		    				<td><a href="/javaee_exam1/updategoods?goods.goodsId=${goodsItem.goodsId} }">修改</a></td>
		    				<td><a href="/javaee_exam1/deletegoods?goods.goodsId=${goodsItem.goodsId} }">删除</a></td>
		    			</tr>
		    		</s:else>
		    	</s:iterator>
		    	<!-- 迭代商品结束 -->
		    </table>
		</s:if>
  </body>
</html>
