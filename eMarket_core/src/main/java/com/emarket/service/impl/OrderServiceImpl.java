package com.emarket.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.Customer;
import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Market;
import com.eMarket.model.po.Order;
import com.emarket.constant.OrderStatus;
import com.emarket.dao.FactoryDAO;
import com.emarket.dao.OrderDAO;
import com.emarket.service.OrderService;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.LongPrimaryKeyGenerator;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private FactoryDAO factoryDAO;
	@Autowired
	private OrderDAO orderDAO;

	private LengthPrimaryKeyGenerator<Long> generator=new LongPrimaryKeyGenerator();
	
	@Override
	public List<FactoryItem> getFactoryItemByGoodsIdOverAmount(long goodsId,int amount){
		Map<String,Object> condition=new HashMap<>();
		condition.put("goodsId", goodsId);
		condition.put("canDealedQuantity",amount);
		List<FactoryItem> list=factoryDAO.fetchFactoryItem(condition);
		return list;
	}
	
	@Override
	public Order createOrder(long goodsId,long marketId,String username,int quantity,float amount){
		
		Order order=new Order();
		order.setId(generator.generatePrimaryKey(9));
		order.setCreateTime(new Date());
		
		Customer customer = new Customer();
		customer.setUsername(username);
		Market market=new Market();
		market.setId(marketId);
		Goods goods=new Goods();
		goods.setId(goodsId);
		
		order.setCustomer(customer);
		order.setGoods(goods);
		order.setMarket(market);
		order.setQuantity(quantity);
		order.setAmount(amount);
		order.setStatus(OrderStatus.USER_CREATE_SUCCESS);
		return order;
	}
	
	@Override
	public Order saveOrder(Order order,long factoryId){
//		int j=factoryDAO.minusFactory(factoryId,order.getQuantity());
		int i=orderDAO.saveOrder(order);
		if(i==1){
			order=orderDAO.getOrderById(order.getId());
			return order;
		}else{
			return null;
		}
	}
}
