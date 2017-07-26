package com.emarket.dao;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Market;
import com.eMarket.model.po.MarketDetail;

public interface MarketDAO {
	
	/**
	 * 向数据库中保存一条商店信息
	 * @param market 待保存的商店信息
	 * @return 成功保存了多少条记录
	 */
	int saveMarketDetail(MarketDetail market);
	/**
	 * 从数据库中删除商店信息
	 * @param id
	 * @return
	 */
	int removeMarketDetail(long id);
	
	/**
	 * 更新商店信息，依据传入的商店对象的id更新
	 * @param market
	 * @return
	 */
	int updateMarketDetail(MarketDetail market);
	
	/**
	 * 根据id查找对应的商店信息
	 * @param id 商店id
	 * @return
	 */
	Market getMarketById(long id);
	
	/**
	 * 根据id查找对应的商品详情信息
	 * @param id
	 * @return
	 */
	MarketDetail getMarketDetailById(long id);
	
	/**
	 * 搜索满足条件的商店
	 * @param condition 条件
	 * 1,id，long类型，可选，限制id
	 * 2，name，String型，可选，匹配商店名称
	 * 3，status，int型，可选，限制商店状态
	 * @return
	 */
	List<Market> fetchMarket(Map<String,Object> condition);
}
