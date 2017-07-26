package com.emarket.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Goods;
import com.emarket.common.Page;
import com.emarket.constant.FetchMode;
import com.emarket.dao.FactoryDAO;
import com.emarket.dao.GoodsDAO;
import com.emarket.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsDAO goodsDAO;
	
	@Override
	public List<Goods> fetchGoods(String key,Integer mode){
		Map<String,Object> condition=new HashMap<>();
		List<Goods> list=null;
		if(mode!=null){
			if (FetchMode.ACCORDING_TO_GOODS_NAME==mode) {
				condition.put("name", key);
				list=goodsDAO.fetchGoods(condition);
			}else if(FetchMode.ACCORDING_TO_BRAND_NAME==mode){
				condition.put("brand.name", key);
				list=goodsDAO.fetchGoods(condition);
			}else if(FetchMode.ACCORDING_TO_TYPE_NAME==mode){
				condition.put("type.name", key);
				list=goodsDAO.fetchGoods(condition);
			}else{
				list=goodsDAO.fetchGoods(condition);
			}
		}else{
			list=goodsDAO.fetchGoods(condition);
		}
		return list;
	}
	
	@Override
	public Page<Goods> loadPage(Map<String,Object> condition,int startPage,int pageSize){
		Page<Goods> page=new Page<>();
		if(startPage<=0){
			startPage=0;
		}else{
			startPage-=1;
		}
		int fetchedSize=goodsDAO.countFetchedGoods(condition);
		page.setFetchedAmount(fetchedSize);
		page.setPageAmount(fetchedSize/pageSize+(fetchedSize%pageSize>0?1:0));
		if(startPage>page.getPageAmount()){
			startPage = page.getPageAmount();
		}
		int startIndex=startPage*pageSize;
		page.setContent(goodsDAO.loadPage(condition, startIndex, pageSize));
		page.setPageNum(startPage+1);
		return page;
	}

	@Override
	public Goods getGoodsById(long id){
		return goodsDAO.getGoodsById(id);
	}
}
