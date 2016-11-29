package com.mallbywjz.serviceaction;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mallbywjz.biz.UserBiz;
import com.mallbywjz.entity.Admins;
import com.mallbywjz.entity.Users;

public class UserAction implements RequestAware, SessionAware {
	
	private String type;		//用户类型user or admin
	private String userId;		//用户ID
	private String adminId;		//管理员ID
	private String upwd;		//用户密码
	private String apwd;		//管理员密码
	private Users user;
	private Admins admin;
	UserBiz userBiz;
	Map<String,Object> session;
	Map<String,Object> request;
	
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	
	public UserBiz getUserBiz() {
		return userBiz;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public String getUpwd() {
		return upwd;
	}


	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}


	public String getApwd() {
		return apwd;
	}


	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	
	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Admins getAdmin() {
		return admin;
	}


	public void setAdmin(Admins admin) {
		this.admin = admin;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	public String login()throws Exception{		//登录
		List list = null;
		
		if(type.equals("user")){
			Users user=new Users();
			user.setUserId(userId);
			user.setPwd(upwd);
			list=userBiz.login(user);
			if(list.size()>0){
				session.put("user",list.get(0));
				return "ULS";  //userLoginSuccess
			}else{
				return "ULF";	//userLoginFail
			}
		}else if(type.equals("admin")){
			Admins admin=new Admins();
			admin.setAdminId(adminId);
			admin.setPwd(apwd);
			list=userBiz.login(admin);
			if(list.size()>0){
				session.put("admin",list.get(0));
				return "ALS";  //adminLoginSuccess
			}else{
				return "ALF";	//adminLoginFail
			}
		}else 
			return null;
	}
	
	public String register()throws Exception{		//注册
		if(type.equals("user")){
			Users user=new Users();
			user.setUserId(userId);
			user.setPwd(upwd);
			if(userBiz.register(user))
				return "URS";
			else
				return "URF";
		}else if(type.equals("admin")){
			Admins admin=new Admins();
			admin.setAdminId(adminId);
			admin.setPwd(apwd);
			if(userBiz.register(admin))
				return "ARS";
			else
				return "ARF";
		}else
			return null;
	}
	
	public String logout()throws Exception{		//注销
		if(type.equals("user")){
			session.remove("user");
		}else if(type.equals("admin")){
			session.remove("admin");
		}
		return "index";							//返回到首页
	}
	
	public String modifyInfo()throws Exception{
		if(type.equals("user")){
			userBiz.modifyInfo(user);
			session.remove("user");   //修改成功返回到登录页
			return "userlogin";
		}else if(type.equals("admin")){
			userBiz.modifyInfo(admin);
			session.remove("admin");
			return "adminlogin";		//修改成功返回到登录页
		}	
		return null;	
	}
	
	public String showUsers()throws Exception{
		List userList=null;
		if(user==null){
			userList=userBiz.allUsers();
		}else{
			userList=userBiz.userBySelect(user);
		}
		request.put("userList",userList);
		
		return "showusers";
	}
	
	public String deleteUser()throws Exception{
		userBiz.deleteUser(user);
		return "showusers";
	}
	
	public String showQueryPage()throws Exception{
		List userList=null;
		userList=userBiz.userBySelect(user);
		Users user1=new Users();
		user1=(Users)userList.get(0);
		request.put("user",user);
		
		return "showquerypage";
	}
}
