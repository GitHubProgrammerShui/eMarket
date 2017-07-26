package com.emarket.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMarket.model.po.Goods;
import com.emarket.common.Page;
import com.emarket.constant.FetchMode;
import com.emarket.service.GoodsService;

@Controller
@RequestMapping("/product")
public class ProductController{
	
	@Autowired
	private GoodsService goodsService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/fetch")
	public String fetchGoods(@RequestParam(value="key",required=false) String key,
			@RequestParam(value="mode",required=false)Integer mode,
			@RequestParam(value="startPage",required=false,defaultValue="0") Integer startPage,
			HttpServletRequest request){
		
		Map<String,Object> condition=null;
		if(mode==null){
			condition=(Map<String, Object>) request.getSession().getAttribute("condition");
			condition=condition!=null?condition:new HashMap<String,Object>();
		}else{
			condition=createCondition(key, mode);
		}
		Page<Goods> page=goodsService.loadPage(condition,startPage,12);
		request.getSession().setAttribute("condition", condition);
		request.setAttribute("page",page);
		return "forward:/productList.jsp";
	}
	
	@RequestMapping("/getGoodsInfo")
	public String getDetail(@RequestParam("id")Integer id,HttpServletRequest request){
		Goods goods=goodsService.getGoodsById(id);
		request.setAttribute("goods", goods);
		return "forward:/productDetailInfo.jsp";
	}
	
	private Map<String,Object> createCondition(String key,int mode){
		Map<String,Object> condition=new HashMap<>();
		if(mode==FetchMode.ACCORDING_TO_BRAND_NAME){
			condition.put("brand_name",key);
		}else if(mode==FetchMode.ACCORDING_TO_TYPE_NAME){
			condition.put("type_name",key);
		}else{
			condition.put("name",key);
		}
		return condition;
	}
}
