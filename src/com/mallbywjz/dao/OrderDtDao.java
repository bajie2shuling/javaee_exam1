package com.mallbywjz.dao;

import java.util.List;

import com.mallbywjz.entity.Orderdetials;

public interface OrderDtDao {
	public void addOrderDt(Orderdetials orderdt);  //生成子订单
	public List getOrderDtsByOid(int oid);//根据订单主表编号获取订单明细列表
}
