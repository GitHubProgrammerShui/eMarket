package com.emarket.admin.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Worker;
import com.eMarket.model.po.WorkerDetail;
import com.eMarket.model.vo.Result;
import com.eMarket.model.vo.WorkerParam;

/**
 * 工作人员管理
 * @author 添加工作人员信息
 *
 */
public interface WorkerManageSerivce{
	
	/**
	 * 向数据库保存一条工作人员信息
	 * @param workerParam 
	 * @return
	 */
	WorkerDetail saveWorker(WorkerParam workerParam);
	/**
	 * 移除数据库中指定用户名的记录
	 * @param username 指定用户名
	 * @return 移除成功或失败
	 */
	boolean removeWorker(String username);
	/**
	 * 更新指定的工作人员信息
	 * @param worker 更新工作人员
	 * @return
	 */
	boolean updateWorker(WorkerDetail worker);
	
	/**
	 * 根据传入的username查找对应的工作人员信息
	 * @param username 用户名
	 * @return 指定的工作人员信息
	 */
	Worker getWorkerByUsername(String username);
	/**
	 * 根据传入的条件查找对应的工作人员信息
	 * @return
	 */
	List<Worker> fetchWorker(Map<String,Object> condition);
	
	/**
	 * 上传照片
	 * @param uploadParam
	 * @param inputStream
	 * @return
	 */
	Result uploadToFtpServer(Map<String,String> uploadParam,InputStream uploadStream);
	
	WorkerDetail getWorkerDetailByUsername(String username);
	
	WorkerDetail createWorkerDetail(WorkerParam workerParam);
	WorkerDetail updateWorkerDetail(WorkerParam workerParam);
	
	
}
