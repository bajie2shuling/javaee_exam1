package com.mallbywjz.dao;

import java.util.List;

import com.mallbywjz.entity.Orders;
import com.mallbywjz.entity.Users;

public interface OrdersDao {
	public List getOrderByIdL(Orders order);//���ݶ�����Ų�ѯ����
	public void changeState(Orders order);//�޸Ķ���״̬
	public List getAllOrders();//ȡ�����ж���
	public List getOrdersByUser(Users user);//�����û���ѯ����
}
