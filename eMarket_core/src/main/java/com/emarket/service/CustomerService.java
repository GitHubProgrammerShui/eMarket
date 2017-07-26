package com.emarket.service;

import java.io.InputStream;
import java.util.Map;

import com.eMarket.model.po.CustomerDetail;
import com.eMarket.model.vo.CustomerDetailParam;
import com.eMarket.model.vo.Result;

public interface CustomerService {

	CustomerDetail getCustomerDetailByUsername(String username);
	
	CustomerDetail updateCustomerDetail(String username,CustomerDetailParam customerDetailParam);

	Result uploadToFtpServer(Map<String, String> uploadParam, InputStream inputStream);
}