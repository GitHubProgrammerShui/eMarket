package com.emarket.admin.service;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Order;

public interface OrderManageService {

	boolean updateOrderStatus(long id, int status);

	List<Order> fetchOrder(Map<String, Object> condition);

	boolean minusFactory(long goodsId, long marketId);
}