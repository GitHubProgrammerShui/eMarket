package com.emarket.admin.service;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Brand;
import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Type;

public interface FactoryService {

	boolean saveOrAddFactoryItem(FactoryItem factoryItem);

	List<FactoryItem> fetchFactoryItem(Map<String, Object> condition);

	boolean removeFactoryItem(Long id);

	List<Brand> listBrand();

	List<Type> listType();

	List<Goods> fetchGoodsByBrandAndType(long brandId, long typeId);
	
	FactoryItem createItem(long goodsId,long marketId,int quantity);
}