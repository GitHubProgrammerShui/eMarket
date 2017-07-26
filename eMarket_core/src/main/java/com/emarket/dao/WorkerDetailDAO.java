package com.emarket.dao;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.WorkerDetail;

/**
 * 用户详情数据访问层
 * @author shuibaoqin
 *
 */
public interface WorkerDetailDAO{
	
	/**
	 * 向数据库保存一条工作人员详情信息
	 * @param workerDetail
	 * @return
	 */
	int saveWorkerDetail(WorkerDetail workerDetail);
	/**
	 * 根据用户名删除对应的用户详情
	 * @param username
	 * @return
	 */
	int removeWorkerDetail(String username);
	/**
	 * 更新username指定的用户详情信息
	 * @param workerDetail
	 * @return
	 */
	int updateWorkerDetail(WorkerDetail workerDetail);
	/**
	 * 根据用户名查找对应的工作人员详情
	 * @param username
	 * @return
	 */
	WorkerDetail getWorkerDetailByUsername(String username);
	/**
	 * 根据条件查询满足条件的对象
	 * @param condition 条件
	 * 1，username，String型，可选，限制用户名<br>
	 * 2，lowestReward和highestReward，float型，可选，限制工作人员薪水范围<br>
	 * 3，startRegisterTime和stopRegisterTime，java.util.Date型，可选，限制注册时间范围
	 * 4，comment，String型，可选，匹配备注
	 * 5，sex，String型，可选，限制性别
	 * 6，lowestAge和highestAge，int型，可选，限制年龄范围
	 * 7，idCard，String型，可选，匹配身份证号
	 * 8，address，String型，可选，匹配地址
	 * 9，accountCardNo，String型，可选，匹配银行卡号
	 * 10，tel，String型，可选，匹配手机号
	 * 11，email，String型，可选，匹配邮箱
	 * 12，qq，String型，可选，匹配qq号
	 * @return
	 */
	List<WorkerDetail> fetchWorkerDetail(Map<String,Object> condition);
}
