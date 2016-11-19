<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>修改商品信息</title>
  </head>
  
  <body>
     <%@taglib prefix="s" uri="/struts-tags"%>
	   	<div align="center">
	    	|<a href="/javaee_exam1/showgoods">商城首页</a>
	    	|<a href="login.jsp?role=admin">商品管理</a>
	    	|
	   	</div><hr>
	 
	 <div align="center">
	    	<form action="modifygoods" method="post" >
				<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
						<tr style="background-color:#9c2e41;">
							<td colspan="2">
								商品信息
							</td>
						</tr>
						<tr align="center" >
							<td align="right" style="width:320px;" >
								商品编号：
							</td>
							<td align="left">							    
								<input type="text" name="admin.adminId" style="width:220px;" value="${requestScope.goods.goodsId }" readonly="readonly" />									
							</td>
						</tr>
						<tr>
							<td align="right" style="width:320px;">
								商  品  名：
							</td>
							<td align="left">
								<input type="password" name="admin.pwd" style="width:220px;"  value="${requestScope.goods.goodsName }"/>									
							</td>
						</tr>
						<tr>
							<td align="right" style="width:320px;">
								商品价格：
							</td>
							<td align="left">
								<input type="password" name="admin.pwd" style="width:220px;" value="${requestScope.goods.goodsPrice }" />									
							</td>
						</tr>
						<tr style="background-color:#9c2e41;">
								<td colspan="2">
									<input type="submit" value="修改" />
								</td>
						</tr>
	    		</table>
	    	</form>
	    </div>
  </body>
</html>
