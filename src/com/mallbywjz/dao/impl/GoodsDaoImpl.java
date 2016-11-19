package com.mallbywjz.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.mallbywjz.dao.GoodsDao;
import com.mallbywjz.entity.Goods;


public class GoodsDaoImpl implements GoodsDao {
	
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public void AddGoods(Goods goods) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		session.save(goods);   
		trans.commit();					
		session.close();
	}

	@Override
	public void modifyGoods(Goods goods) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		session.update(goods);   
		trans.commit();					
		session.close();
	}

	@Override
	public void deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		session.delete(goods);   
		trans.commit();					
		session.close();
	}

	@Override
	public List AllGoods() {
		// TODO Auto-generated method stub
		
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Goods");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public List GoodsBySelect(Goods goods) {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Goods as goods where goods.goodsName like '%"+goods.getGoodsName()+"%'");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public List GoodsById(Goods goods) {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Goods as goods where goods.goodsId='"+goods.getGoodsId()+"'");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}


}
