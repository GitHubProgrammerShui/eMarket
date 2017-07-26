package com.emarket.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Order;
import com.emarket.admin.service.OrderManageService;
import com.emarket.constant.OrderStatus;
import com.emarket.dao.FactoryDAO;
import com.emarket.dao.OrderDAO;

@Service("orderManageService")
public class OrderManageServiceImpl implements OrderManageService {
	
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private FactoryDAO factoryDAO;
	
	@Override
	public boolean updateOrderStatus(long id,int status){
		Order order=orderDAO.getOrderById(id);
		if(order!=null){
			if(status==OrderStatus.ORDER_COMPLETE){
				FactoryItem item=this.getFactoryItemByGoodsIdAndMarketId(order.getGoods().getId(),order.getMarket().getId());
				if(item!=null){
					if(factoryDAO.minusFactory(item.getId(),order.getQuantity())==1){
						order.setStatus(status);
						int i=orderDAO.updateOrder(order);
						return i==1; 
					}else{
						return false;
					}
				}else{
					return false;
				}
			}else{
				order.setStatus(status);
				int i=orderDAO.updateOrder(order);
				return i==1; 
			}
		}
		return false;
	}
	
	@Override
	public boolean minusFactory(long goodsId,long marketId){
		return false;
	}
	
	@Override
	public List<Order> fetchOrder(Map<String,Object> condition){
		return orderDAO.fetchOrder(condition);
	}
	
	private FactoryItem getFactoryItemByGoodsIdAndMarketId(long goodsId,long marketId){
		HashMap<String, Object> condition = new HashMap<>();
		condition.put("goodsId",goodsId);
		condition.put("marketId",marketId);
		List<FactoryItem> items=factoryDAO.fetchFactoryItem(condition);
		if(items.isEmpty()){
			return null;
		}else{
			return items.get(0);
		}
	}
}
