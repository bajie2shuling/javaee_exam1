package com.mallbywjz.serviceaction;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.mallbywjz.biz.OrderDtBiz;
import com.mallbywjz.biz.OrdersBiz;
import com.mallbywjz.entity.Orderdetials;
import com.mallbywjz.entity.Orders;
import com.mallbywjz.entity.SCarItem;
import com.mallbywjz.entity.Users;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport implements RequestAware,SessionAware{
	
	private static final long serialVersionUID = 1L;

	private Orders orders;
	private int oid;
	OrderDtBiz orderDtBiz;
	OrdersBiz ordersBiz;
	
	Map<String, Object> session;
	Map<String, Object> request;
	

	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
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
	
	public String addOrder()throws Exception{		//���ɶ���
		Orders order=new Orders();
		order.setOrderState("δ����");
		order.setOrderTime(new Date());
		order.setOrderTotalPrice((Double)session.get("sumPrice"));
		order.setUsers((Users)session.get("user"));
		
		Map scar=(HashMap)session.get("scar");
		Iterator iter=scar.keySet().iterator();//����set������
		
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
	
	public String userSeeOrders()throws Exception{		//�û��鿴�Լ��Ķ���
		
		List orderList=null;
		
		Users user=new Users();
		user=(Users)session.get("user");
		
		orderList=ordersBiz.getOrdersByUser(user);
		
		request.put("orderList", orderList);
		
		return "showuserorders";
	}
	
	public String seeAllOrders()throws Exception{		//����Ա��ѯ���ж���
		List orderList=null;
		orderList=ordersBiz.getAllOrders();
		
		request.put("orderList", orderList);
		
		return "showorders";
	}
	
	public String changeState()throws Exception{		//��˶���
		ordersBiz.changeState(orders);
		return "showorders";
	}
	
	public String seeOrderDt()throws Exception{		//�鿴��������
		
		List orderDtList=null;
		orderDtList=orderDtBiz.getOrderDtsByOid(oid);
		request.put("orderDtList", orderDtList);
		
		return "showorderdt";
	}
}
