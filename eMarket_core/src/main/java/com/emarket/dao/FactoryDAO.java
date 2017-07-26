package com.emarket.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eMarket.model.po.FactoryItem;

public interface FactoryDAO {
	
	/**
	 * 向数据库保存一条记录
	 * @param factoryItem
	 * @return
	 */
	int saveFactory(FactoryItem factoryItem);
	
	/**
	 * 删除一个库存
	 * @param id
	 * @return
	 */
	int removeFactory(long id);
	
	/**
	 * 更新
	 * @param factoryItem
	 * @return
	 */
	int updateFactory(FactoryItem factoryItem);
	
	/**
	 * 根据id获取对应的库存
	 * @param id
	 * @return
	 */
	FactoryItem getFactoryItemById(long id);
	
	/**
	 * 查找
	 * @param condition
	 * @return
	 */
	List<FactoryItem> fetchFactoryItem(Map<String,Object> condition);
	
	/**
	 * 向一个库存项新增数量
	 * @param id
	 * @param amount
	 * @return
	 */
	int addFactory(@Param("id") long id,@Param("amount") int amount);
	
	/**
	 * 减少一个库存项的数量
	 * @param id
	 * @param amount
	 * @return
	 */
	int minusFactory(@Param("id") long id,@Param("amount") int amount);
}
