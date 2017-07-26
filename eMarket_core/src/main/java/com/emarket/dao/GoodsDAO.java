package com.emarket.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eMarket.model.po.Goods;

public interface GoodsDAO {
	
	/**
	 * 向数据库中保存一条商品信息
	 * @param goods 要保存的商品信息
	 * @return 保存成功返回保存的商品在数据库中的id，保存失败返回0
	 */
	int saveGoods(Goods goods);

	/**
	 * 删除数据库中指定的商品
	 * @param goods 要删除的商品对象id
	 */
	int removeGoods(long id);

	/**
	 * 更新数据库中指定的商品，以传入的商品的id为依据查找对应的商品
	 * @param goods 更新后的商品
	 */
	int updateGoods(Goods goods);

	/**
	 * 根据给定的id查找对应的商品对象
	 * @return 如果查到了商品返回该商品，否则返回null
	 */
	Goods getGoodsById(long id);

	/**
	 * 根据条件查询满足条件的商品
	 * @param condition 查询条件，以map形式传入，可以传入以下值：<br>
	 * 1,id：long类型，若传入该值，则查询以id为该值的商品<br>
	 * 2，name：String类型，若传入该值，则匹配查询商品名称包含该值的商品<br>
	 * 3，brand.id：long类型，若传入该值，则查询品牌号为该值的商品<br>
	 * 4，brand.name：String类型，可选，匹配品牌名称
	 * 5，type.id：long类型，若传入该值，则查询type的id为该值的商品<br>
	 * 6，type.name：String类型，可选，匹配类型名称
	 * 7，lowestPrice和highestPrice：float类型，若传入这两个值，则查询商品价格price在指定范围内的商品，这两个值必须同时给才会有效<br>
	 * 8，status：byte类型，若指定该值，则查询商品状态为给定值的商品
	 * 上面的参数不要给null，否则会出错
	 * @return 满足条件的商品集合
	 */
	List<Goods> fetchGoods(Map<String, Object> condition);
	
	/**
	 * 计算搜索出来的商品数量
	 * @param condition
	 * @return
	 */
	int countFetchedGoods(Map<String,Object> condition);
	
	/**
	 * 加载页信息
	 * @param condition
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Goods> loadPage(@Param("condition")Map<String,Object> condition,@Param("startIndex") int startIndex,@Param("pageSize") int pageSize);
}