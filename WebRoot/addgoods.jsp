<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>添加商品</title>
	<link rel="stylesheet" type="text/css" href="css/my.css">
	</head>
	<body>
		<%@taglib prefix="s" uri="/struts-tags"%>
		<s:if test="#session.admin!=null">		
	    	<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
	    	   	 <tr style="background-color:#9c2e41;">	
		    	   	 <td><a href="/javaee_exam1/showgoods">商城首页</a></td>
			    	 <td><a href="modifyInfo.jsp?role=admin">修改个人信息</a></td>
			    	 <td><a href="/javaee_exam1/goodsmanage">商品管理</a></td>
			    	 <td><a href="/javaee_exam1/showusers">用户管理</a></td>
			    	 <td><a href="/javaee_exam1/seeallorders">订单管理</a></td>
			    	 <td><a href="/javaee_exam1/logout?type=admin">注销</a></td>
					 <td><marquee><font style="color: #00ff00">管理员：${sessionScope.admin.adminId }</font></marquee></td>
				 </tr>
		   </table><hr>
	    	
	    	<form action="addgoods" method="post">
				<table width="50%" cellspacing="0" cellpadding="3" align="center" style="text-align:center; border:1px #9c2e41 solid;">
					<tr style="background-color:#9c2e41;">
						<td colspan="2">
							添加商品
						</td>
					</tr>
					<tr align="center" >
						<td align="right" style="width:320px;" >
							商  品  名：
						</td>
						<td align="left">							    
							<input type="text" name="goods.goodsName" style="width:220px;"  />									
						</td>
					</tr>
					<tr>
						<td align="right" style="width:320px;">
							商品价格：
						</td>
						<td align="left">
							<input type="text" name="goods.goodsPrice" style="width:220px;"  />									
						</td>
					</tr>
					<tr style="background-color:#9c2e41;">
							<td colspan="2">
								<input type="submit" value="添加" />
							</td>
					</tr>
				</table>
			</form>
		</s:if>
	</body>
</html>
