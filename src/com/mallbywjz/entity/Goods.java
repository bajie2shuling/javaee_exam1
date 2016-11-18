package com.mallbywjz.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private String goodsName;
	private Double goodsPrice;
	private Set orderdetialses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(String goodsName, Double goodsPrice, Set orderdetialses) {
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.orderdetialses = orderdetialses;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Set getOrderdetialses() {
		return this.orderdetialses;
	}

	public void setOrderdetialses(Set orderdetialses) {
		this.orderdetialses = orderdetialses;
	}

}