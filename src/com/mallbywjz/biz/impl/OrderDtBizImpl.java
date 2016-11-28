package com.mallbywjz.biz.impl;

import java.util.List;

import com.mallbywjz.biz.OrderDtBiz;
import com.mallbywjz.dao.OrderDtDao;
import com.mallbywjz.entity.Orderdetials;

public class OrderDtBizImpl implements OrderDtBiz {
	
	OrderDtDao orderDtDao;
	
	public void setOrderDtDao(OrderDtDao orderDtDao) {
		this.orderDtDao = orderDtDao;
	}

	@Override
	public void addOrderDt(Orderdetials orderdt) {
		// TODO Auto-generated method stub
		orderDtDao.addOrderDt(orderdt);
	}

	@Override
	public List getOrderDtsByOid(int oid) {
		// TODO Auto-generated method stub
		return orderDtDao.getOrderDtsByOid(oid);
	}

	@Override
	public int getGoodsCount(int gid) {
		// TODO Auto-generated method stub
		return orderDtDao.getGoodsCount(gid);
	}

}
