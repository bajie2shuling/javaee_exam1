package com.mallbywjz.biz;

import java.util.List;

import com.mallbywjz.entity.Goods;

public interface GoodsBiz {
	public void AddGoods(Goods goods);//�����Ʒ
	public void updateGoods(Goods goods);//�޸���Ʒ
	public void deleteGoods(Goods goods);//ɾ����Ʒ
	public List AllGoods();//ȡ��������Ʒ
	public List GoodsBySelect(Goods goods);//���ݲ�ѯ����ȡ����Ʒ
}
