package com.mallbywjz.biz.impl;

import java.util.List;

import com.mallbywjz.biz.UserBiz;
import com.mallbywjz.dao.UserDao;
import com.mallbywjz.entity.Admins;
import com.mallbywjz.entity.Users;

public class UserBizImpl implements UserBiz {
	UserDao userDao;
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	
	
	@Override
	public List login(Users user) {    //用户登录
		return userDao.login(user);
	}

	@Override
	public List login(Admins admin) {	//管理员登录
		return userDao.login(admin);
	}
	
	@Override
	public boolean register(Users user) {	//用户注册
		return userDao.register(user);
	}

	@Override
	public boolean register(Admins admin) {		//管理员注册
		return userDao.register(admin);
	}


	@Override
	public void modifyInfo(Users user) {
		// TODO Auto-generated method stub
		userDao.modifyInfo(user);
	}


	@Override
	public void modifyInfo(Admins admin) {
		// TODO Auto-generated method stub
		userDao.modifyInfo(admin);
	}


	@Override
	public List userBySelect(Users user) {
		// TODO Auto-generated method stub
		return userDao.userBySelect(user);
	}


	@Override
	public void deleteUser(Users user) {
		// TODO Auto-generated method stub
		userDao.deleteUser(user);
	}


	@Override
	public List allUsers() {
		// TODO Auto-generated method stub
		return userDao.allUsers();
	}

}
