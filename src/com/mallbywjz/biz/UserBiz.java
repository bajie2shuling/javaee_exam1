package com.mallbywjz.biz;

import java.util.List;

import com.mallbywjz.entity.Admins;
import com.mallbywjz.entity.Users;

public interface UserBiz {
	public List login(Users user);	//用户登录验证
	public List login(Admins admin);	//管理员登录验证
	public boolean register(Users user);  //用户注册
	public boolean register(Admins admin); //管理员注册
	public void modifyInfo(Users user);//用户修改信息（密码）
	public void modifyInfo(Admins admin);//管理员修改信息（密码）
	public List userBySelect(Users user);//用户查询
	public void deleteUser(Users user);//删除用户
	public List allUsers();//取得所有用户
}
