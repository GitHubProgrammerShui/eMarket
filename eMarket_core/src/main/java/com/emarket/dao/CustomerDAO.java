package com.emarket.dao;

import java.util.List;
import java.util.Map;

import com.eMarket.model.po.Customer;
import com.eMarket.model.po.CustomerDetail;

/**
 * 用户DAO
 * @author 水保勤
 *
 */
public interface CustomerDAO{
	
	/**
	 * 向数据库保存一条用户数据
	 * @param customer
	 * @return
	 */
	public int saveCustomer(CustomerDetail customer);
	
	/**
	 * 删除指定用户名的用户
	 * @param username
	 * @return
	 */
	public int removeCustomer(String username);
	
	/**
	 * 更新用户信息
	 * @param customer
	 * @return 
	 */
	public int updateCustomer(CustomerDetail customer);
	
	/**
	 * 根据用户名查找对应的用户
	 * @param username
	 * @return
	 */
	public Customer getCustomerByUsername(String username);
	
	/**
	 * 根据username查找一个用户的详情信息
	 * @param username
	 * @return
	 */
	public CustomerDetail getCustomerDetailByUsername(String username);
	
	/**
	 * 根据条件查找满足条件的用户
	 * @param condition
	 * 1，username，可选，String类型，匹配查询username
	 * 2，name，可选，String类型，匹配查询name
	 * 3，userType，可选，String类型，匹配查询userType
	 * @return
	 */
	public List<Customer> fetchCustomer(Map<String,Object> condition);
}
