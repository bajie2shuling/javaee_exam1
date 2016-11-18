package com.mallbywjz.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Users users;
	private Timestamp orderTime;
	private String orderState;
	private Double orderTotalPrice;
	private Set orderdetialses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Users users, Timestamp orderTime, String orderState,
			Double orderTotalPrice, Set orderdetialses) {
		this.users = users;
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.orderTotalPrice = orderTotalPrice;
		this.orderdetialses = orderdetialses;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Double getOrderTotalPrice() {
		return this.orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Set getOrderdetialses() {
		return this.orderdetialses;
	}

	public void setOrderdetialses(Set orderdetialses) {
		this.orderdetialses = orderdetialses;
	}

}