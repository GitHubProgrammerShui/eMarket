package com.emarket.admin.service;

import com.eMarket.model.po.Market;
import com.eMarket.model.po.Worker;

/**
 * 基础服务接口
 * @author shuibaoqin
 *
 */
public interface BasisService{
	
	/**
	 * 登录服务
	 * @param username 用户名
	 * @param password 密码
	 * @return 如果根据用户名和密码找到了对应的工作人员，则返回该工作人员，如果找到了多个
	 */
	Worker login(String username,String password);
	
	/**
	 * 根据商店获取对应的商店
	 * @param username
	 * @return
	 */
	public Market getMarketById(long id);
}
