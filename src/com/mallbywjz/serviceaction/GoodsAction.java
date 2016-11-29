package com.mallbywjz.serviceaction;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.mallbywjz.biz.GoodsBiz;
import com.mallbywjz.biz.OrderDtBiz;
import com.mallbywjz.entity.Goods;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;
	
	private Goods goods;
	GoodsBiz goodsBiz;
	OrderDtBiz orderDtBiz;
	Map<String,Object> request;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public GoodsBiz getGoodsBiz() {
		return goodsBiz;
	}
	public void setGoodsBiz(GoodsBiz goodsBiz) {
		this.goodsBiz = goodsBiz;
	}
	
	public OrderDtBiz getOrderDtBiz() {
		return orderDtBiz;
	}
	public void setOrderDtBiz(OrderDtBiz orderDtBiz) {
		this.orderDtBiz = orderDtBiz;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	public String addGoods()throws Exception{		//�����Ʒ
		goodsBiz.AddGoods(goods);
		
		return "goodsmanage";
	}
	
	public String goodsManage()throws Exception{	//������Ʒ
		
		List goodsList=null;
		if(goods != null){
			goodsList=goodsBiz.GoodsBySelect(goods);
			if(goods.getGoodsName() != null && !goods.getGoodsName().equals("")){
				request.put("goodsName",goods.getGoodsName());
			}
		}else{
			goodsList=goodsBiz.AllGoods();
		}
		
		request.put("goodsList", goodsList);
		return "goodsmanage";
	}
	
	public String goodsByIdG()throws Exception{  //ͨ����ƷId������Ʒ
			
		request.put("goodsList", goodsBiz.GoodsByIdG(goods));
		
		return "goodsmanage";
	}
	
	public String showGoods()throws Exception{		//չʾ��Ʒ
		
		List goodsList=null;
		if(goods != null){
			goodsList=goodsBiz.GoodsBySelect(goods);
			if(goods.getGoodsName() != null && !goods.getGoodsName().equals("")){
				request.put("goodsName",goods.getGoodsName());
			}
		}else{
			goodsList=goodsBiz.AllGoods();
		}
		
		request.put("goodsList", goodsList);
		return "showgoods";
	}
	
	public String modifyGoodsInfo()throws Exception{		//��ȡ�޸���Ʒ��Ϣ
				
		request.put("goods", goodsBiz.GoodsByIdG(goods));
		
		return "modifygoodsinfo";
	}
	
	public String modifyGoods()throws Exception{		//�޸���Ʒ��Ϣ
		
		List goodsList=null;
		
		goodsBiz.modifyGoods(goods);
		goodsList=goodsBiz.GoodsByIdL(goods);		//��ȡ�޸ĺ����Ϣ
	
		request.put("goodsList", goodsList);
		return "goodsmanage";
	}
	
	public String deleteGoods()throws Exception{		//ɾ����Ʒ
		
		orderDtBiz.deleteOrderDtByGoods(goods);
		goodsBiz.deleteGoods(goods);
		return "goodsmanage";
	}
}

