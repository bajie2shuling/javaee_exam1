package com.mallbywjz.biz;

import java.util.List;

import com.mallbywjz.entity.Orders;
import com.mallbywjz.entity.Users;

public interface OrdersBiz {
	public List getOrderByIdL(Orders order);//根据订单编号查询订单
	public void changeState(Orders order);//修改订单状态
	public List getAllOrders();//取得所有订单
	public List getOrdersByUser(Users user);//根据用户查询订单
	public void deleteOrderByUser(Users user);//根据用户Id删除 订单
}
