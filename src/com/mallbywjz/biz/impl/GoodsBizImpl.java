package com.mallbywjz.biz.impl;

import java.util.List;

import com.mallbywjz.biz.GoodsBiz;
import com.mallbywjz.dao.GoodsDao;
import com.mallbywjz.entity.Goods;

public class GoodsBizImpl implements GoodsBiz {
	
	GoodsDao goodsDao;

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public void AddGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.AddGoods(goods);
	}

	@Override
	public void modifyGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.modifyGoods(goods);
	}

	@Override
	public void deleteGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.deleteGoods(goods);
	}

	@Override
	public List AllGoods() {
		// TODO Auto-generated method stub
		return goodsDao.AllGoods();
	}

	@Override
	public List GoodsBySelect(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.GoodsBySelect(goods);
	}

	@Override
	public List GoodsById(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.GoodsById(goods);
	}

}
