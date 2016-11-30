package com.mallbywjz.biz;

import java.util.List;

import com.mallbywjz.entity.Goods;
import com.mallbywjz.entity.Orderdetials;
import com.mallbywjz.entity.Users;

public interface OrderDtBiz {
	public void addOrderDt(Orderdetials orderdt);  //�����Ӷ���
	public List getOrderDtsByOid(int oid);//���ݶ��������Ż�ȡ������ϸ�б�
	public int getGoodsCount(int gid);//������Ʒ���ͳ����Ʒ����
	public int getGoodsCountByTime(String time,Users user);//ͳ��ĳ�˿�һ��ʱ���ڹ������Ʒ����
	public double getGoodsPriceByTime(String time,Users user);//ͳ��ĳ�˿�һ��ʱ���ڹ������Ʒ�����ļ�Ǯ
	public void deleteOrderDtByGoods(Goods goods);//������Ʒɾ������ϸ��
	public void deleteOrderDtByUser(Users user);//�����û�Idɾ������ϸ��
}
