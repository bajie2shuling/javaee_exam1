package com.mallbywjz.entity;

public class SCarItem {
	private Goods goods;//��Ʒ
	private int num;//����
	
	public SCarItem(Goods goods,int num){		//���캯��
		this.goods=goods;
		this.num=num;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
