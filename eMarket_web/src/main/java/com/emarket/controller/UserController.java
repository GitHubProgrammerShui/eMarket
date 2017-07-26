package com.emarket.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eMarket.model.po.Customer;
import com.eMarket.model.po.CustomerDetail;
import com.eMarket.model.vo.CustomerDetailParam;
import com.eMarket.model.vo.CustomerParam;
import com.eMarket.model.vo.Result;
import com.emarket.service.CustomerService;
import com.emarket.util.FileNameUtil;
import com.emarket.util.PropsUtil;

@Controller
@RequestMapping("/auth/user")
public class UserController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("fetchOrderByUser")
	public String getOrderByUser(HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/currentUser")
	public String getCurrentUserDetail(HttpServletRequest request){
		Customer customer=(Customer) request.getSession().getAttribute("customer");
		if(customer!=null){
			request.setAttribute("customerDetail",customerService.getCustomerDetailByUsername(customer.getUsername()));
			return "userInfo.jsp";
		}else{
			request.setAttribute("tips","您还没有登录，请登录");
			return "forward:/login.jsp";
		}
	}
	
	@RequestMapping("/initUpdate")
	public String initUpdate(HttpServletRequest request){
		Customer customer=(Customer) request.getSession().getAttribute("customer");
		request.setAttribute("customerDetail",customerService.getCustomerDetailByUsername(customer.getUsername()));
		return "userInfoChange.jsp";
	}
	
	@RequestMapping("/update")
	public String update(CustomerDetailParam param,HttpServletRequest request){
		Customer customer=(Customer) request.getSession().getAttribute("customer");
		CustomerDetail customerDetail=customerService.updateCustomerDetail(customer.getUsername(), param);
		if (customerDetail!=null) {
			request.setAttribute("customerDetail", customerDetail);
			request.setAttribute("tips", "修改成功");
		}else{
			request.setAttribute("tips","修改失败");
		}
		return "userInfo.jsp";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public Result upload(@RequestParam("photo") MultipartFile multiFile){
		Result result=new Result();
		Map<String,String> uploadParam=PropsUtil.getMap("customerImageUploadProfile");
		uploadParam.put("fileName",FileNameUtil.createNewFileName(multiFile.getOriginalFilename()));
		try {
			result=customerService.uploadToFtpServer(uploadParam,multiFile.getInputStream());
		} catch (IOException e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setTips("获取文件流异常");
		}
		return result;
	}
}
