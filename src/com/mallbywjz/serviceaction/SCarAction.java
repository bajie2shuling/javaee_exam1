package com.mallbywjz.serviceaction;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.mallbywjz.biz.GoodsBiz;
import com.mallbywjz.entity.Goods;
import com.mallbywjz.entity.SCarItem;
import com.opensymphony.xwork2.ActionSupport;

public class SCarAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1L;
	
	Map<String, Object> session;
	private Goods goods;	
	GoodsBiz goodsBiz;
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

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
	
	public String addToScar()throws Exception{   //添加商品到购物车
		Map scar=(Map)session.get("scar");
		Goods goods1=goodsBiz.GoodsByIdG(goods);
		
		if(scar==null){		//没有购物车就新建一个
			scar=new HashMap();
			session.put("scar", scar);
		}
		
		SCarItem scarItem=(SCarItem)scar.get(goods1.getGoodsId());//尝试去购物车取当前商品
		if(scarItem!=null){		//不为空直接加数量
			scarItem.setNum(scarItem.getNum()+1);
		}else{		//否者创建一个放到购物车
			scar.put(goods1.getGoodsId(), new SCarItem(goods1,1));
		}
		
		return "showcar";
	}
	
	public String addItemNum()throws Exception{		//在购物车添加商品数量
		Map scar=(Map)session.get("scar");
		Goods goods1=goodsBiz.GoodsByIdG(goods);
		SCarItem scarItem=(SCarItem)scar.get(goods1.getGoodsId());
		scarItem.setNum(scarItem.getNum()+1);
		return "showcar";
	}
	
	public String reduceItemNum()throws Exception{	//在购物车减少商品数量
		Map scar=(Map)session.get("scar");
		Goods goods1=goodsBiz.GoodsByIdG(goods);
		SCarItem scarItem=(SCarItem)scar.get(goods1.getGoodsId());
		if(scarItem.getNum()==1){
			scar.remove(goods1.getGoodsId());
		}else{
			scarItem.setNum(scarItem.getNum()-1);
		}
		return "showcar";
	}
	
	public String deleteItem() throws Exception {		//从购物车中移除指定商品
		
	    Map scar=(Map)session.get("scar");
	    Goods goods1=goodsBiz.GoodsByIdG(goods);
	    scar.remove(goods1.getGoodsId());
	    return "showcar";
	}	
	
	
	public String clearCar() throws Exception {		//清空购物车
		
	    Map scar=(Map)session.get("scar");
	    scar.clear();
	    return "showcar";
	}
}
