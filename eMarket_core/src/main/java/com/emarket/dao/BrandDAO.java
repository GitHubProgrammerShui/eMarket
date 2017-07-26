package com.emarket.dao;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Brand;

public interface BrandDAO {

	/**
	 * 向数据库保存一条品牌信息
	 * @param brand 待保存的品牌对象
	 * @return 影响了多少条数据
	 */
	int saveBrand(Brand brand);

	/**
	 * 删除数据库中一条品牌信息
	 * @param brand 要删除的品牌对象，其中包含了要删除的对象在数据库中的id
	 * @return 影响了多少条数据
	 */
	int removeBrand(long id);
	
	/**
	 * 根据给定的品牌id更新对应的品牌信息
	 * @param brand 更新后的对象，以其中的id查找数据库中需要更新的记录
	 * @return 影响了多少条数据
	 */
	int update(Brand brand);

	/**
	 * 根据给定的id查询对应的品牌
	 * @param id 要查询的品牌的id
	 * @return 如果查到了对应的品牌则返回该品牌，若没有查到则返回null
	 */
	Brand getBrandById(long id);

	/**
	 * 根据传入的条件查询相应的品牌，使用Map对象传入条件
	 * @param condition 传入的条件，可传入以下条件：<br>
	 * 1,id：long类型，若指定该参数，则查询id号等于该值的对象<br>
	 * 2，name：String类型，若指定该参数，则查询品牌name包含该值的品牌对象<br>
	 * 3，lowestLevel和highestLevel：Integer类型，指定品牌level的范围，两个参数必须同时提供才能有效<br>
	 * 4，startCreateTime和lastCreateTime：java.util.Date类型，指定品牌创建时间的范围，两个参数必须同时提供才能有效<br>
	 * 5，country：String类型，若给定该值，则针对品牌所属国家进行模糊匹配查询<br>
	 * 上面的参数在传入时不要传入null，否则会报空指针异常
	 * @return 满足条件的品牌集合
	 */
	List<Brand> fetchBrands(Map<String, Object> condition);

}