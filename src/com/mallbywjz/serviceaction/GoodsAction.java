package com.mallbywjz.serviceaction;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.mallbywjz.biz.GoodsBiz;
import com.mallbywjz.entity.Goods;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;
	
	private Goods goods;
	GoodsBiz goodsBiz;
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
	
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
	public String addGoods()throws Exception{		//添加商品
		goodsBiz.AddGoods(goods);
		
		return "goodsmanage";
	}
	
	public String goodsManage()throws Exception{	//管理商品
		
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
	
	public String goodsById()throws Exception{  //通过商品Id查找商品
		List goodsList=null;
		goodsList=goodsBiz.GoodsById(goods);		
		request.put("goodsList", goodsList);
		
		return "goodsmanage";
	}
	
	public String showGoods()throws Exception{		//展示商品
		
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
	
	public String modifyGoodsInfo()throws Exception{		//获取修改商品信息
		List goodsList=null;

		goodsList=goodsBiz.GoodsById(goods);		
		request.put("goods", goodsList.get(0));
		
		return "modifygoodsinfo";
	}
	
	public String modifyGoods()throws Exception{		//修改商品信息
		
		List goodsList=null;
		
		goodsBiz.modifyGoods(goods);
		goodsList=goodsBiz.GoodsById(goods);		//获取修改后的信息
	
		request.put("goodsList", goodsList);
		return "goodsmanage";
	}
	
	public String deleteGoods()throws Exception{		//删除商品
		
		goodsBiz.deleteGoods(goods);
		return "goodsmanage";
	}
}

