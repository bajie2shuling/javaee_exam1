package com.mallbywjz.dao;

import java.util.List;

import com.mallbywjz.entity.Goods;
import com.mallbywjz.entity.Orderdetials;
import com.mallbywjz.entity.Users;

public interface OrderDtDao {
	public void addOrderDt(Orderdetials orderdt);  //生成子订单
	public List getOrderDtsByOid(int oid);//根据订单主表编号获取订单明细列表
	public int getGoodsCount(int gid);//根据商品编号统计商品销量
	public int getGoodsCountByTime(String time,Users user);//统计某顾客一段时间内购买的商品数量
	public double getGoodsPriceByTime(String time,Users user);//统计某顾客一段时间内购买的商品所花的价钱
	public void deleteOrderDtByGoods(Goods goods);//根据商品删除订单细节
}
