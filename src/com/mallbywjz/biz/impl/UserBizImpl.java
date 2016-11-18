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
	public List login(Users user) {    //�û���¼
		return userDao.login(user);
	}

	@Override
	public List login(Admins admin) {	//����Ա��¼
		return userDao.login(admin);
	}
	
	@Override
	public boolean register(Users user) {	//�û�ע��
		return userDao.register(user);
	}

	@Override
	public boolean register(Admins admin) {		//����Աע��
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

}
