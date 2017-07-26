package com.emarket.dao;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Type;

public interface TypeDAO {

	/**
	 * 向数据库保存一条类型对象
	 * @param type 待保存的类型对象
	 * @return 成功保存几笔数据
	 */
	int saveType(Type type);

	/**
	 * 删除指定的Type对象
	 * @param type 待删除的Type对象，其中必须要传入id字段，以便让hibernate找到要删除的记录
	 * @return 删除了多少笔数据
	 */
	int removeType(long id);
	
	/**
	 * 根据传入的待更新的Type对象，更新数据库的Type对象，以传入的Type对象的id值为依据查找数据库中需要修改的Type
	 * @param type 更新后的Type
	 * @return 更新了多少笔数据
	 */
	int updateType(Type type);

	/**
	 * 根据给定的id值查找数据库中对应的类型对象
	 * @param id 需要查找的Type的id值
	 * @return 若查到该对象返回该对象，若没有查到返回null
	 */
	Type getTypeById(long id);

	/**
	 * 根据条件从数据库中取出满足条件的对象
	 * @param condition 条件对象，以Map形式传入，可传入以下值：<br>
	 * 1，id：long类型，若传入该值，则查询id等于该值的Type对象<br>
	 * 2，name：String类型，若传入该值，则匹配查询name包含该值的Type对象<br>
	 * 3，startCreateTime和stopCreateTime：两个都是java.util.Date类型，若指定这两个值，则查询createTime位于两个值之间的Type，两个
	 * 值必须同时给，只给其中一个无效<br>
	 * 4，comment：String类型，若指定该值，则匹配查询comment包含该值的Type<br>
	 * 上面的参数不要给null，否则会出错
	 * @return 满足条件的Type对象
	 */
	List<Type> fetchTypes(Map<String, Object> condition);

}