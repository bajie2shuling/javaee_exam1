package com.mallbywjz.entity;

/**
 * Orderdetials entity. @author MyEclipse Persistence Tools
 */

public class Orderdetials implements java.io.Serializable {

	// Fields

	private Integer orderDetialId;
	private Goods goods;
	private Orders orders;
	private Double goodsPrice;
	private Integer goodsCount;

	// Constructors

	/** default constructor */
	public Orderdetials() {
	}

	/** full constructor */
	public Orderdetials(Goods goods, Orders orders, Double goodsPrice,
			Integer goodsCount) {
		this.goods = goods;
		this.orders = orders;
		this.goodsPrice = goodsPrice;
		this.goodsCount = goodsCount;
	}

	// Property accessors

	public Integer getOrderDetialId() {
		return this.orderDetialId;
	}

	public void setOrderDetialId(Integer orderDetialId) {
		this.orderDetialId = orderDetialId;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsCount() {
		return this.goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

}