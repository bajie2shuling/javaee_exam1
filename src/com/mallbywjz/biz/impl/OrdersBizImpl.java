package com.mallbywjz.biz.impl;

import java.util.List;

import com.mallbywjz.biz.OrdersBiz;
import com.mallbywjz.dao.OrdersDao;
import com.mallbywjz.entity.Orders;
import com.mallbywjz.entity.Users;

public class OrdersBizImpl implements OrdersBiz {
	
	OrdersDao ordersDao;
	
	public OrdersDao getOrdersDao() {
		return ordersDao;
	}

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public List getAllOrders() {
		// TODO Auto-generated method stub
		return ordersDao.getAllOrders();
	}

	@Override
	public void changeState(Orders order) {
		// TODO Auto-generated method stub
		ordersDao.changeState(order);
	}

	@Override
	public List getOrderByIdL(Orders order) {
		// TODO Auto-generated method stub
		return ordersDao.getOrderByIdL(order);
	}

	@Override
	public List getOrdersByUser(Users user) {
		// TODO Auto-generated method stub
		return ordersDao.getOrdersByUser(user);
	}

	@Override
	public void deleteOrderByUser(Users user) {
		// TODO Auto-generated method stub
		ordersDao.deleteOrderByUser(user);
	}


}
