package com.emarket.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMarket.model.condition.OrderSelectCondition;
import com.eMarket.model.po.Market;
import com.eMarket.model.po.Order;
import com.emarket.admin.service.OrderManageService;
import com.emarket.constant.OrderStatus;

/**
 * 订单控制器类
 * @author shuibaoqin
 * 
 */
@Controller
@RequestMapping("/admin/order")
public class OrderManageController{
	
	@Autowired
	private OrderManageService orderManageService;
	
	@RequestMapping("/fetch")
	public String fetch(OrderSelectCondition condition,HttpServletRequest request){
		Map<String, Object> map = condition.toMap();
		//指定的管理员只能查看到自己的订单
		Market market=(Market) request.getSession().getAttribute("market");
		map.put("marketId",market.getId());
		List<Order> list=orderManageService.fetchOrder(map); 
		request.setAttribute("orderList", list);
		request.getSession().setAttribute("orderCondition",map);
		return "items/order/list.jsp";
	}
	
	@RequestMapping("/handle")
	public String handle(@RequestParam("id")long id,HttpServletRequest request){
		if(orderManageService.updateOrderStatus(id,OrderStatus.WORKER_DEALED)){
			request.setAttribute("orderList", orderManageService.fetchOrder((Map<String, Object>) request.getSession().getAttribute("orderCondition")));
			return "items/order/list.jsp";
		}else{
			request.setAttribute("tips","处理失败");
			return "items/order/success.jsp";
		}
	}
	
	@RequestMapping("/refuse")
	public String refuse(@RequestParam("id")long id,HttpServletRequest request){
		if(orderManageService.updateOrderStatus(id,OrderStatus.WORKER_REFUSED)){
			request.setAttribute("orderList", orderManageService.fetchOrder((Map<String, Object>) request.getSession().getAttribute("orderCondition")));
			return "items/order/list.jsp";
		}else{
			request.setAttribute("tips","处理失败");
			return "items/order/success.jsp";
		}
	}
	
	@RequestMapping("/complete")
	public String complete(@RequestParam("id")long id,HttpServletRequest request){
		if(orderManageService.updateOrderStatus(id,OrderStatus.ORDER_COMPLETE)){
			request.setAttribute("orderList", orderManageService.fetchOrder((Map<String, Object>) request.getSession().getAttribute("orderCondition")));
			return "items/order/list.jsp";
		}else{
			request.setAttribute("tips","处理失败");
			return "items/order/success.jsp";
		}
	}
	
	@RequestMapping("/stop")
	public String stop(@RequestParam("id")long id,HttpServletRequest request){
		if(orderManageService.updateOrderStatus(id,OrderStatus.ORDER_FAILURE)){
			request.setAttribute("orderList", orderManageService.fetchOrder((Map<String, Object>) request.getSession().getAttribute("orderCondition")));
			return "items/order/list.jsp";
		}else{
			request.setAttribute("tips","处理失败");
			return "items/order/success.jsp";
		}
	}
}
