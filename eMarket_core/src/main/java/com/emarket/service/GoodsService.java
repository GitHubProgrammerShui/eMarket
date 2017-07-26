package com.emarket.service;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Goods;
import com.emarket.common.Page;

public interface GoodsService {

	List<Goods> fetchGoods(String key, Integer mode);

	Page<Goods> loadPage(Map<String, Object> condition, int startPage, int pageSize);
	
	Goods getGoodsById(long id);
}