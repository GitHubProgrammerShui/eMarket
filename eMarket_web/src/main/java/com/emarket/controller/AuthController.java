package com.emarket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMarket.model.po.Customer;
import com.eMarket.model.po.CustomerDetail;
import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Market;
import com.eMarket.model.po.Order;
import com.emarket.service.CustomerService;
import com.emarket.service.GoodsService;
import com.emarket.service.OrderService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/initOrderInfo")
	public String initOrderInfo(@RequestParam("goodsId") Long goodsId,
				@RequestParam("amount")Integer amount,
				HttpServletRequest request){
		if(amount!=null&goodsId!=null){
			List<FactoryItem> list=orderService.getFactoryItemByGoodsIdOverAmount(goodsId, amount);
			if(list.isEmpty()){
				request.setAttribute("tips","目前没有任何商店能够满足您的需求，请您调整购物的数量或选择其他的商品看看");
				return "forward:/error.jsp";
			}else{
				FactoryItem item=list.get(0);
				Map<String,Object> orderMap=new HashMap<>();
				orderMap.put("factoryId",item.getId());
				orderMap.put("goods", item.getGoods());
				orderMap.put("market",item.getMarket());
				orderMap.put("amount",amount);
				Customer customer = (Customer) request.getSession().getAttribute("customer");
				if(customer!=null){
					orderMap.put("customerDetail",customerService.getCustomerDetailByUsername(customer.getUsername()));
				}else{
					return "forward:/login.jsp";
				}
				request.getSession().setAttribute("orderMap",orderMap);
				return "orderInfo.jsp";
			}
		}else{
			request.setAttribute("tips","缺少必要参数");
			return "forward:/error.jsp";
		}
	}
	
	@RequestMapping("/submit")
	public String submitOrder(HttpServletRequest request){
		Map<String,Object> orderMap=(Map<String, Object>) request.getSession().getAttribute("orderMap");
		if(orderMap!=null){
			long factoryId=(long) orderMap.get("factoryId");
			Goods goods=(Goods) orderMap.get("goods");
			Market market=(Market) orderMap.get("market");
			CustomerDetail customerDetail=(CustomerDetail) orderMap.get("customerDetail");
			int quantity = (int) orderMap.get("amount");
			float amount=goods.getPrice()*quantity;
			Order order=orderService.createOrder(goods.getId(),market.getId(),customerDetail.getCustomer().getUsername(),quantity,amount);
			order=orderService.saveOrder(order, factoryId);
			if(order!=null){
				request.setAttribute("tips","成功");
				return "result.jsp";
			}else{
				request.setAttribute("tips","订单创建失败");
				return "forward:/error.jsp";
			}
		}else{
			request.setAttribute("tips","没有足够的参数");
			return "forward:/error.jsp";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().invalidate();
		return "forward:/index.jsp";
	}
}
