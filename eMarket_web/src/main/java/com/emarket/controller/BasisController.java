package com.emarket.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eMarket.model.po.Customer;
import com.eMarket.model.po.CustomerDetail;
import com.eMarket.model.vo.CustomerParam;
import com.eMarket.model.vo.Result;
import com.emarket.util.FileNameUtil;
import com.emarket.util.PropsUtil;
import com.emarket.service.WebBasisService;

@Controller
public class BasisController {
	
	@Autowired
	private WebBasisService webBasisService;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password,HttpSession session){
		Customer customer=webBasisService.login(username, password);
		if(customer!=null){
			session.setAttribute("customer", customer);
			String target=(String) session.getAttribute("targetUri");
			if(target!=null){
				return "forward:"+target;
			}else{
				return "index.jsp";
			}
		}else{
			return "forward:/login.jsp";
		}
	}
	
	@RequestMapping("/register")
	public String register(CustomerParam customerParam,HttpServletRequest request){
		CustomerDetail customerDetail=webBasisService.register(customerParam);
		if(customerDetail!=null){
			request.setAttribute("tips","注册成功");
			request.setAttribute("customerDetail", customerDetail);
		}else{
			request.setAttribute("tips", "注册失败");
		}
		return "forward:/result.jsp";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public Result upload(@RequestParam("photo") MultipartFile multiFile){
		Result result=new Result();
		Map<String,String> uploadParam=PropsUtil.getMap("customerImageUploadProfile");
		uploadParam.put("fileName",FileNameUtil.createNewFileName(multiFile.getOriginalFilename()));
		try {
			result=webBasisService.uploadToFtpServer(uploadParam,multiFile.getInputStream());
		} catch (IOException e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setTips("获取文件流异常");
		}
		return result;
	}
}
