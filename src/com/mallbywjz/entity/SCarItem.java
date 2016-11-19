package com.mallbywjz.entity;

public class SCarItem {
	private Goods goods;//商品
	private int num;//数量
	
	public SCarItem(Goods goods,int num){		//构造函数
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
