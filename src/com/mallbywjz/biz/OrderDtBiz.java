package com.mallbywjz.biz;

import java.util.List;

import com.mallbywjz.entity.Orderdetials;

public interface OrderDtBiz {
	public void addOrderDt(Orderdetials orderdt);  //�����Ӷ���
	public List getOrderDtsByOid(int oid);//���ݶ��������Ż�ȡ������ϸ�б�
	public int getGoodsCount(int gid);//������Ʒ���ͳ����Ʒ����
}
