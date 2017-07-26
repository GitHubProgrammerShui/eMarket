package com.emarket.service;

import java.io.InputStream;
import java.util.Map;

import com.eMarket.model.po.Customer;
import com.eMarket.model.po.CustomerDetail;
import com.eMarket.model.vo.CustomerParam;
import com.eMarket.model.vo.Result;

public interface WebBasisService {

	Customer login(String username, String password);

	CustomerDetail register(CustomerParam customerParam);

	/**
	 * 上传照片到ftp资源服务器
	 * @param uploadParam
	 * @param inputStream
	 * @return
	 */
	Result uploadToFtpServer(Map<String, String> uploadParam, InputStream inputStream);

}