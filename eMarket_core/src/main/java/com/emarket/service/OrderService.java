package com.emarket.service;

import java.util.List;

import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Order;

public interface OrderService {

	List<FactoryItem> getFactoryItemByGoodsIdOverAmount(long goodsId, int amount);

	Order createOrder(long goodsId, long marketId, String username, int quantity,float amount);

	Order saveOrder(Order order, long factoryId);

}