package com.emarket.admin.service;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Brand;

public interface BrandManageService {

	/**
	 * 向数据库中保存一条品牌记录
	 * @param brand 待保存的品牌对象
	 * @return 保存结果
	 */
	Brand saveBrand(Brand brand);
	
	/**
	 * 删除对应的品牌
	 * @param id
	 * @return
	 */
	boolean removeBrand(long id);
	/**
	 * 修改数据库中的品牌，根据传入的品牌对象中的品牌编号进行搜索
	 * @param brand 待修改的品牌
	 * @return 修改结果
	 */
	Brand updateBrand(Brand brand);

	/**
	 * 根据id查找对应的品牌信息
	 * @param id 要查找的品牌的id
	 * @return 查找结果，成功则data字段显示查找到的品牌信息，失败则data字段为空
	 */
	Brand getBrandById(long id);

	/**
	 * 依据传入的条件搜索满足条件的品牌对象
	 * @param condition 传入的条件
	 * @return 满足条件的品牌对象
	 */
	List<Brand> fetchBrand(Map<String,Object> condition);

}