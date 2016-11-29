<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户管理</title>
  </head>
  <body>
	<%@taglib prefix="s" uri="/struts-tags"%>
		<s:if test="#session.admin!=null">
			<div align="center">
	    	    |<a href="/javaee_exam1/showgoods">商城首页</a>
		    	|<a href="modifyInfo.jsp?role=admin">修改个人信息</a>
		    	|<a href="/javaee_exam1/goodsmanage">商品管理</a>
		    	|<a href="/javaee_exam1/seeallorders">订单管理</a>
		    	|<a href="/javaee_exam1/logout?type=admin">注销</a>
		    	|&nbsp;&nbsp; &nbsp;&nbsp;
				<font style="color: red">管理员：${sessionScope.admin.adminId }</font>
		    </div><hr>
		    
		    <form action="showusers" method="post">
			    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
			    	<tr style="background-color:#9c2e41;">
			    		<td align="right" style="width:320px;">
			    			输入用户名
			    		</td>
			    		<td align="left">
			    			<input type="text" name="user.userId" style="width:220px;" />
			    		</td>
			    		<td align="left">
			    			<input type="submit" value="查询"/>
			    		</td>
			    	</tr>
			    </table>
			 </form>  
		    <table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
		    	<tr style="background-color:#d9f1f2;">
		    		<td>用户名</td>
		    		<td>查询消费情况</td>
		    		<td>删除</td>
		    	</tr>
		    	
		    	<!-- 迭代用户 -->
		    	<s:iterator id="userItem" value="#request.userList" status="st">
		    		<s:if test="#st.odd==true">
		    			<tr style="background-color:#f1e0b3;">
		    				<td><s:property value="userId" /></td>
		    				<td><a href="/javaee_exam1/showquerypage?user.userId=${userItem.userId}">查询消费情况</a></td>
		    				<td><a href="/javaee_exam1/deleteuser?user.userId=${userItem.userId}">删除</a></td>
		    			</tr>
		    		</s:if>	
		    		<s:else>
		    			<tr style="background-color:#d9f1f2;">
		    				<td><s:property value="userId" /></td>
		    				<td><a href="/javaee_exam1/showquerypage?user.userId=${userItem.userId}">查询消费情况</a></td>
		    				<td><a href="/javaee_exam1/deleteuser?user.userId=${userItem.userId}">删除</a></td>
		    			</tr>
		    		</s:else>
		    	</s:iterator>
		    	<!-- 迭代用户结束 -->
		    </table>
		</s:if>
  </body>
</html>
