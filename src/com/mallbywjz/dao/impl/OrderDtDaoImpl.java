package com.mallbywjz.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mallbywjz.dao.OrderDtDao;
import com.mallbywjz.entity.Orderdetials;

public class OrderDtDaoImpl implements OrderDtDao {

	
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;
	}
		
	@Override
	public void addOrderDt(Orderdetials orderdt) {		//生成子订单
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		session.saveOrUpdate(orderdt);   
		trans.commit();					
		session.close();
	}

	@Override
	public List getOrderDtsByOid(int oid) {	//根据订单主表编号获取订单明细列表
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Orderdetials as odt where odt.orders.orderId='"+oid+"'");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

}
