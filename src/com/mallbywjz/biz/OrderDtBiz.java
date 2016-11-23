package com.mallbywjz.biz;

import java.util.List;

import com.mallbywjz.entity.Orderdetials;

public interface OrderDtBiz {
	public void addOrderDt(Orderdetials orderdt);  //生成子订单
	public List getOrderDtsByOid(int oid);//根据订单主表编号获取订单明细列表
}
