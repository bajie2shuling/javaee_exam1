package com.mallbywjz.dao;

import java.util.List;

import com.mallbywjz.entity.Goods;

public interface GoodsDao {
	public void AddGoods(Goods goods);//�����Ʒ
	public void modifyGoods(Goods goods);//�޸���Ʒ
	public void deleteGoods(Goods goods);//ɾ����Ʒ
	public List AllGoods();//ȡ��������Ʒ
	public List GoodsBySelect(Goods goods);//���ݲ�ѯ����ȡ����Ʒ
	public List GoodsById(Goods goods);//������ƷIdȡ����Ʒ
}
