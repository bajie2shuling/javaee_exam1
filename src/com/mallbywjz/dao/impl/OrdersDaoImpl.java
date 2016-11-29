package com.mallbywjz.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mallbywjz.dao.OrdersDao;
import com.mallbywjz.entity.Orders;
import com.mallbywjz.entity.Users;

public class OrdersDaoImpl implements OrdersDao {
	
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Override
	public List getAllOrders() {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Orders as orders order by orders.orderTime desc");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

	@Override
	public void changeState(Orders order) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("update Orders  set orderState='"+"“—¥¶¿Ì'"+" where orderId='"+order.getOrderId()+"'");
		query.executeUpdate();
		trans.commit();
		session.close();
	}
	
	@Override
	public List getOrderByIdL(Orders order) {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Orders as orders order by orders.orderTime desc where orders.orderId='"+order.getOrderId()+"'");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}
	
	@Override
	public List getOrdersByUser(Users user) {
		// TODO Auto-generated method stub
		List list=null;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Orders as orders where orders.users.userId='"+user.getUserId()+"' order by orders.orderTime desc");
		list=query.list();
		trans.commit();
		session.close();
		return list;
	}

}
