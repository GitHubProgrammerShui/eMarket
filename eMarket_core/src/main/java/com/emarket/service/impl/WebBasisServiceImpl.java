package com.emarket.service.impl;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.Customer;
import com.eMarket.model.po.CustomerDetail;
import com.eMarket.model.vo.CustomerParam;
import com.eMarket.model.vo.Result;
import com.emarket.dao.CustomerDAO;
import com.emarket.service.WebBasisService;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.StringPrimaryKeyGenerator;

@Service("webBasisService")
public class WebBasisServiceImpl implements WebBasisService {
	
	@Autowired
	private CustomerDAO customerDAO;
	@Autowired
	private FTPClient ftpClient;
	
	private LengthPrimaryKeyGenerator<String> generator=new StringPrimaryKeyGenerator();
	
	@Override
	public Customer login(String username,String password){
		Customer customer=customerDAO.getCustomerByUsername(username);
		if(customer!=null){
			if(customer.getPassword()!=null&&customer.getPassword().equals(password)){
				return customer;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	@Override
	public CustomerDetail register(CustomerParam customerParam){
		CustomerDetail customerDetail=this.createCustomerDetail(customerParam);
		int i=customerDAO.saveCustomer(customerDetail);
		if(i==1){
			return customerDetail;
		}else{
			return null;
		}
	}
	
	private CustomerDetail createCustomerDetail(CustomerParam customerParam){
		CustomerDetail customerDetail=new CustomerDetail();
		Customer customer=new Customer();
		customer.setUsername(generator.generatePrimaryKey(18));
		customer.setPassword(customerParam.getPassword());
		customer.setName(customerParam.getName());
		customer.setUserType("普通用户");
		customerDetail.setCustomer(customer);
		customerDetail.setCreateTime(new Date());
		customerDetail.setImage(customerParam.getImage());
		customerDetail.setSex(customerParam.getSex());
		customerDetail.setLevel(0);
		customerDetail.setScore(0);
		return customerDetail;
	}

	@Override
	public Result uploadToFtpServer(Map<String, String> params, InputStream uploadStream) {
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
