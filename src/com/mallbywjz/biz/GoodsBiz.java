package com.mallbywjz.biz;

import java.util.List;

import com.mallbywjz.entity.Goods;

public interface GoodsBiz {
	public void AddGoods(Goods goods);//添加商品
	public void updateGoods(Goods goods);//修改商品
	public void deleteGoods(Goods goods);//删除商品
	public List AllGoods();//取得所有商品
	public List GoodsBySelect(Goods goods);//根据查询条件取得商品
}
