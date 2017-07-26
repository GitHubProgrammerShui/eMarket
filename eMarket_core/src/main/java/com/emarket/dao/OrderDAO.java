package com.emarket.dao;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Order;

public interface OrderDAO {
	
	/**
	 * 向数据库保存一条订单信息
	 * @param order
	 * @return
	 */
	int saveOrder(Order order);
	
	/**
	 * 移除指定order
	 * @param id
	 * @return
	 */
	int removeOrder(long id);
	
	/**
	 * 更新订单
	 * @param order
	 * @return
	 */
	int updateOrder(Order order);
	
	/**
	 * 查找订单
	 * @param id
	 * @return
	 */
	Order getOrderById(long id);
	
	/**
	 * 根据条件查询订单
	 * @param condition 条件：<br>
	 * 1，id：long型，可选，查询指定订单id<br>
	 * 2，startCreateTime和endCreateTime：java.util.Date型，可选，查询创建时间在指定时间范围之间的订单<br>
	 * 3，lowestAmount和highestAmount，float型，可选，限制总金额的范围<br>
	 * 4，lowestQuantity和highestQuantity，int型，可选，限制订购数量<br>
	 * 5，status，int型，可选，限制订单状态<br>
	 * 6，goodsId，long型，可选，显示商品id<br>
	 * 7，goodsName，String型，可选，匹配查询商品名<br>
	 * 8，lowestGoodsPrice和highestGoodsPrice，float型，可选，限制商品价格范围<br>
	 * 9，goodsStatus，byte型，可选，限制商品状态<br>
	 * 10，startGoodsCreateTime和endGoodsCreateTime，java.util.Date型，可选，限制商品创建时间的范围<br>
	 * 11，goodsContent，String类型，可选，匹配商品的信息<br>
	 * 12，goodsBrandId，long型，可选，限制品牌id<br>
	 * 13，goodsBrandName，String型，可选，匹配品牌名称<br>
	 * 14，goodsBrandCountry，String型，可选，匹配品牌国家<br>
	 * 15，goodsBrandStartCreateTime和goodsBrandEndCreateTime，java.util.Date型，可选，限制品牌创建时间<br>
	 * 16，goodsBrandLowestLevel和goodsBrandHighestLevel，int型，限制品牌的等级范围<br>
	 * 17，goodsBrandComment，String型，可选，匹配品牌备注<br>
	 * 18，goodsTypeId，long型，可选，限制类型id<br>
	 * 19，goodsTypeName，String型，可选，匹配类型名<br>
	 * 20，goodsTypeStartCreateTime和goodsTypeEndCreateTime，java.util.Date型，可选，限制类型创建时间范围<br>
	 * 21，goodsTypeComment，String型，可选，匹配类型的备注<br>
	 * 22，marketId，long型，可选，限制商店id<br>
	 * 23，marketName，String型，可选，匹配商店名称<br>
	 * 24，marketStatus，int型，可选，限制商店状态<br>
	 * 25，customerUsername，String型，可选，限制用户账号<br>
	 * 26，customerLikeUsername，String，可选，匹配用户账号<br>
	 * 27，customerName，String型，可选，匹配用户姓名<br>
	 * 28，customerUserType，String型，限制用户类型<br>
	 * @return
	 * 	满足条件的订单集合
	 */
	List<Order> fetchOrder(Map<String,Object> condition);
}
