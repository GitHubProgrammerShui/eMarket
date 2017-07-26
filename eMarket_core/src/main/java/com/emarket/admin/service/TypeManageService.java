package com.emarket.admin.service;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Type;

/**
 * 商品类型服务
 * @author 水保勤
 *
 */
public interface TypeManageService{
	
	/**
	 * 向数据库中保存一个类型
	 * @param type 待保存的商品类型
	 * @return 保存成功或失败
	 */
	Type saveType(Type type);
	
	/**
	 * 根据id删除一个商品类型
	 * @param id 要删除的Type的id
	 * @return 删除成功或失败
	 */
	boolean removeType(long id);
	
	/**
	 * 更新类型，但不更新编号，以传入的编号为准
	 * @param type
	 * @return
	 */
	Type updateType(Type type);
	
	/**
	 * 根据id查找对应的类型
	 * @param id
	 * @return
	 */
	Type getTypeById(long id);
	
	/**
	 * 根据查询条件查找对应的类型
	 * @param condition 条件对象，以Map形式传入，可传入以下值：<br>
	 * 1，id：long类型，若传入该值，则查询id等于该值的Type对象<br>
	 * 2，name：String类型，若传入该值，则匹配查询name包含该值的Type对象<br>
	 * 3，startCreateTime和stopCreateTime：两个都是java.util.Date类型，若指定这两个值，则查询createTime位于两个值之间的Type，两个 值必须同时给，只给其中一个无效<br>
	 * 4，comment：String类型，若指定该值，则匹配查询comment包含该值的Type<br>
	 * 上面的参数不要给null，否则会出错<br>
	 * @return
	 */
	List<Type> fetchType(Map<String,Object> condition);
}
