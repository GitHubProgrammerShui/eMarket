package com.emarket.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eMarket.model.po.Worker;
import com.eMarket.model.po.WorkerDetail;

/**
 * 工作人员数据访问层，用于访问工作人员
 * @author shuibaoqin
 *
 */
public interface WorkerDAO {
	/**
	 * 向数据库添加一个工作人员记录
	 * @param worker
	 * @return
	 */
	int saveWorkerDetail(WorkerDetail workerDetail);
	
	/**
	 * 根据工作人员用户名删除该工作人员
	 * @param username 工作人员的用户名
	 * @return
	 */
	int removeWorkerDetail(String username);
	
	/**
	 * 更新指定的工作人员信息
	 * @param worker
	 * @return
	 */
	int updateWorkerDetail(WorkerDetail workerDetail);
	
	/**
	 * 根据工作人员用户名查找对应的工作人员
	 * @param username
	 * @return
	 */
	Worker getWorkerByUsername(String username);
	
	/**
	 * 根据username查找工作人员详情信息
	 * @return
	 */
	WorkerDetail getWorkerDetailByUsername(String username);
	
	/**
	 * 按照条件搜索工作人员
	 * @param condition 搜索条件
	 * 1，username，String型，可选，匹配工作人员用户名
	 * 2，role，String型，限制工作人员角色
	 * 3，name，String型，匹配工作人员姓名
	 * 4，marketId，long型，限制工作人员所属商店
	 * @return 搜索结果
	 */
	List<Worker> fetchWorker(Map<String,Object> condition);
}
