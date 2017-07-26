package com.emarket.admin.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMarket.model.po.Market;
import com.eMarket.model.po.Worker;
import com.eMarket.model.po.WorkerDetail;
import com.emarket.admin.service.BasisService;
import com.emarket.admin.util.PropsUtil;

@Controller
@RequestMapping("/admin")
public class BasisController{
	
	@Autowired
	private BasisService basisService;
	
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpSession session){
		//验证
		Worker worker=basisService.login(username, password);
		if(worker!=null){
			Market market=basisService.getMarketById(worker.getMarketId());
			if (market!=null){
				session.setAttribute("worker", worker);
				session.setAttribute("market", market);
				return "index.jsp";
			}
		}
		return "forward:/login.jsp";
	}
	
	/**
	 * 直接进行访问的页面（相对于WEB-INF下的jsp目录）
	 * @return
	 */
	@RequestMapping("/view/{viewName}")
	public String forward(@PathVariable("viewName") String viewName){
		String view="";
		if(containsView(viewName)){
			view=escape(viewName,"-","/");
			return view+".jsp";
		}else{
			return "forward:/hello.jsp";
		}
	}
	
	private boolean containsView(String viewName){
		List<String> list=PropsUtil.getList("viewCollection");
		for(String string:list){
			if(string.equals(viewName)){
				return true;
			}
		}
		return false;
	}
	private String escape(String str,String escapePattern,String destStr){
		String string=null;
		Pattern pattern=Pattern.compile(escapePattern);
		Matcher matcher=pattern.matcher(str);
		if(matcher.find()){
			string=matcher.replaceAll(destStr);
			return string;
		}
		return str;
	}
}