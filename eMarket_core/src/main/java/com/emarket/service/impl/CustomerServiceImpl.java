package com.emarket.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.CustomerDetail;
import com.eMarket.model.vo.CustomerDetailParam;
import com.eMarket.model.vo.Result;
import com.emarket.dao.CustomerDAO;
import com.emarket.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private FTPClient ftpClient;
	
	@Override
	public CustomerDetail getCustomerDetailByUsername(String username){
		return customerDAO.getCustomerDetailByUsername(username);
	}

	@Override
	public CustomerDetail updateCustomerDetail(String username, CustomerDetailParam customerDetailParam) {
		CustomerDetail customerDetail=customerDAO.getCustomerDetailByUsername(username);
		customerDetail.getCustomer().setPassword(customerDetailParam.getPassword());
		customerDetail.getCustomer().setName(customerDetailParam.getName());
		customerDetail.setAddress(customerDetailParam.getAddress());
		customerDetail.setEmail(customerDetailParam.getEmail());
		customerDetail.setImage(customerDetailParam.getImage());
		customerDetail.setSex(customerDetailParam.getSex());
		customerDetail.setTel(customerDetailParam.getTel());
		if(customerDAO.updateCustomer(customerDetail)==1){
			return customerDetail;
		}else{
			return null;
		}
	}

	/**
	 * 上传文件到文件服务器，使用ftp协议
	 * @param params 传入的参数，需要传入以下值：<br>
	 * 1，ftpHostAddress：文件服务器地址，String类型<br>
	 * 2，username：文件服务器登录用户名，String类型<br>
	 * 3，password：文件服务器登录密码，String类型<br>
	 * 4，uploadPath：上传路径，以“/”开始，表示从根路径开始<br>
	 * 5，fileName：上传文件名，String类型
	 * @param uploadStream 上传的文件流
	 * @return 包含有上传情况的消息的集合
	 */
	@Override
	public Result uploadToFtpServer(Map<String,String> params,InputStream uploadStream){
		Result result=new Result();
		try {
			//连接文件服务器
			ftpClient.connect(params.get("ftpHostAddress"));
			//登录，登录成功后才能进行上传下载文件
			boolean loginOK=ftpClient.login(params.get("username"),params.get("password"));
			if (ftpClient.isConnected()&&loginOK) {
				//设置要在哪个路径放置文件
				ftpClient.changeWorkingDirectory(params.get("uploadPath"));
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.storeFile(params.get("fileName"), uploadStream);
				result.setSuccess(true);
				result.setData(params.get("uploadPath")+"/"+params.get("fileName"));
			} 
		} catch (IOException e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setTips("上传到文件服务器失败");
		} finally {
			if (ftpClient!=null&&ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//返回消息
		return result;
	}
}
