package com.mallbywjz.serviceaction;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mallbywjz.biz.GoodsBiz;
import com.mallbywjz.biz.OrderDtBiz;
import com.mallbywjz.biz.OrdersBiz;
import com.mallbywjz.entity.Goods;
import com.mallbywjz.entity.Orderdetials;
import com.mallbywjz.entity.Orders;
import com.mallbywjz.entity.SCarItem;
import com.mallbywjz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;

	private Orders orders;
	private Goods goods;
	private int oid;//订单编号
	OrderDtBiz orderDtBiz;
	OrdersBiz ordersBiz;
	GoodsBiz goodsBiz;
	
	Map<String, Object> session;
	Map<String, Object> request;
	

	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public OrderDtBiz getOrderDtBiz() {
		return orderDtBiz;
	}
	public void setOrderDtBiz(OrderDtBiz orderDtBiz) {
		this.orderDtBiz = orderDtBiz;
	}
	
	public OrdersBiz getOrdersBiz() {
		return ordersBiz;
	}
	public void setOrdersBiz(OrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
	}
	
	public GoodsBiz getGoodsBiz() {
		return goodsBiz;
	}
	public void setGoodsBiz(GoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	public String addOrder()throws Exception{		//生成订单
		Orders order=new Orders();
		order.setOrderState("未处理");
		order.setOrderTime(new Date());
		order.setOrderTotalPrice((Double)session.get("sumPrice"));
		order.setUsers((Users)session.get("user"));
		
		Map scar=(HashMap)session.get("scar");
		Iterator iter=scar.keySet().iterator();//返回set迭代器
		
		while(iter.hasNext()){
			Object key = iter.next();
			SCarItem scarItem=(SCarItem)scar.get(key);
			
			Orderdetials orderDt=new Orderdetials();
			
			orderDt.setGoods(scarItem.getGoods());
			orderDt.setGoodsCount(scarItem.getNum());
			orderDt.setGoodsPrice(scarItem.getGoods().getGoodsPrice());
			orderDt.setOrders(order);
			
			orderDtBiz.addOrderDt(orderDt);
		}
		
		session.remove("scar");
		return "showuserorders";
	}
	
	public String userSeeOrders()throws Exception{		//用户查看自己的订单
		
		List orderList=null;
		
		Users user=new Users();
		user=(Users)session.get("user");
		
		orderList=ordersBiz.getOrdersByUser(user);
		
		request.put("orderList", orderList);
		
		return "showuserorders";
	}
	
	public String seeAllOrders()throws Exception{		//管理员查询所有订单
		List orderList=null;
		orderList=ordersBiz.getAllOrders();
		
		request.put("orderList", orderList);
		
		return "showorders";
	}
	
	public String changeState()throws Exception{		//审核订单
		ordersBiz.changeState(orders);
		return "showorders";
	}
	
	public String seeOrderDt()throws Exception{		//查看订单详情
		
		List orderDtList=null;
		orderDtList=orderDtBiz.getOrderDtsByOid(oid);
		request.put("orderDtList", orderDtList);
		
		return "showorderdt";
	}
	
	public String getGoodsCount()throws Exception{
		
		int goodsCount=0;
		goods=goodsBiz.GoodsByIdG(goods);
		goodsCount=orderDtBiz.getGoodsCount(goods.getGoodsId());
		request.put("goods",goods);
		request.put("goodsCount",goodsCount);
		
		return "showgoodscount";
	}
}
