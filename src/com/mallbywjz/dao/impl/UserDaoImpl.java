package com.mallbywjz.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.mallbywjz.dao.UserDao;
import com.mallbywjz.entity.Admins;
import com.mallbywjz.entity.Users;

public class UserDaoImpl implements UserDao {
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public List login(Users user) {		//用户登录验证
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Users where userId='"+user.getUserId()+"'"+"and pwd='"+user.getPwd()+"'");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public List login(Admins admin) {		//管理员登录验证
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Admins where adminId='"+admin.getAdminId()+"'"+"and pwd='"+admin.getPwd()+"'");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public boolean register(Users user) {		//用户注册
		List list;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Users where userId='"+user.getUserId()+"'");
		list=query.list();
		trans.commit();
		session.close();						//查询与注册名相同的user
		if(list.size()>0){
			return false;					
		}else{
			Session session1=sessionFactory.openSession();
			session1.clear();
			Transaction trans1=session1.beginTransaction();
			session1.save(user);			
			trans1.commit();					//注册用户持久化到数据库
			session1.close();
			return true;
		}
	}

	@Override
	public boolean register(Admins admin) {		//管理员注册
		List list;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Admins where adminId='"+admin.getAdminId()+"'");
		list=query.list();
		trans.commit();
		session.close();						//查询与注册名相同的admin
		if(list.size()>0){
			return false;					
		}else{
			Session session1=sessionFactory.openSession();
			session1.clear();
			Transaction trans1=session1.beginTransaction();
			session1.save(admin);					
			trans1.commit();				//注册管理员持久化到数据库
			session1.close();
			return true;
		}
	}

	@Override
	public void modifyInfo(Users user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		session.update(user);   //修改用户信息
		trans.commit();					
		session.close();
	}

	@Override
	public void modifyInfo(Admins admin) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		session.update(admin);   //修改管理员信息
		trans.commit();					
		session.close();
	}

	@Override
	public List userBySelect(Users user) {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Users as user where user.userId like '%"+user.getUserId()+"%'");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public void deleteUser(Users user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		session.delete(user);   
		trans.commit();					
		session.close();
	}

	@Override
	public List allUsers() {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Users");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}
	
	
}
