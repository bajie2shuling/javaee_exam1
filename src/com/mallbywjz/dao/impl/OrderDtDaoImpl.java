package com.mallbywjz.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mallbywjz.dao.OrderDtDao;
import com.mallbywjz.entity.Goods;
import com.mallbywjz.entity.Orderdetials;
import com.mallbywjz.entity.Users;

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

	@Override
	public int getGoodsCount(int gid) {
		// TODO Auto-generated method stub
		List list=null;
		int goodsCount=0;
		long count=0;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("select sum(odt.goodsCount) as count from Orderdetials as odt where odt.goods.goodsId='"+gid+"' group by odt.goods.goodsId");
		list=query.list();
		trans.commit();
		session.close();
		count=(Long) list.get(0);
		goodsCount=(int) count;
		return goodsCount;
	}

	@Override
	public int getGoodsCountByTime(String time, Users user) {
		// TODO Auto-generated method stub
		List list=null;
		int goodsCount=0;
		long count=0;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("select sum(odt.goodsCount) as count from Orderdetials as odt where odt.orders.users.userId='"+user.getUserId()+"' and odt.orders.orderTime like '%"+time+"%' group by odt.orders.users.userId");
		list=query.list();
		trans.commit();
		session.close();
		count=(Long) list.get(0);
		goodsCount=(int) count;
		return goodsCount;
	}

	@Override
	public double getGoodsPriceByTime(String time, Users user) {
		// TODO Auto-generated method stub
		List list=null;
		double totalPrice;
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("select sum(odt.orders.orderTotalPrice) as totalprice from Orderdetials as odt where odt.orders.users.userId='"+user.getUserId()+"' and odt.orders.orderTime like '%"+time+"%' group by odt.orders.users.userId");
		list=query.list();
		trans.commit();
		session.close();
		totalPrice= (Double) list.get(0);
		return totalPrice;
	}

	@Override
	public void deleteOrderDtByGoods(Goods goods) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.clear();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("delete from Orderdetials as odt where odt.goods.goodsId='"+goods.getGoodsId()+"'");
		query.executeUpdate();
		trans.commit();
		session.close();
	}

}
