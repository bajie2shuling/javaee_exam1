package com.mallbywjz.dao;

import java.util.List;

import com.mallbywjz.entity.Orderdetials;

public interface OrderDtDao {
	public void addOrderDt(Orderdetials orderdt);  //�����Ӷ���
	public List getOrderDtsByOid(int oid);//���ݶ��������Ż�ȡ������ϸ�б�
	public int getGoodsCount(int gid);//������Ʒ���ͳ����Ʒ����
}
