package com.emarket.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eMarket.model.condition.FactorySelectCondition;
import com.eMarket.model.po.Brand;
import com.eMarket.model.po.FactoryItem;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Market;
import com.eMarket.model.po.Type;
import com.emarket.admin.service.FactoryService;

@Controller
@RequestMapping("/admin/factory")
public class FactoryController{
	
	@Autowired
	private FactoryService factoryService;
	
	@RequestMapping("/fetch")
	public String fetchFactory(FactorySelectCondition condition,HttpServletRequest request){
		Map<String, Object> map = condition.toMap();
		Market market = (Market) request.getSession().getAttribute("market");
		map.put("marketId", market.getId());
		List<FactoryItem> list=factoryService.fetchFactoryItem(map);
		request.setAttribute("factoryItemList",list);
		request.getSession().setAttribute("factoryCondition", map);
		return "items/factory/list.jsp";
	}
	
	@RequestMapping("/getBrand")
	@ResponseBody
	public List<Brand> getBrand(){
		return factoryService.listBrand();
	}
	
	@RequestMapping("/getType")
	@ResponseBody
	public List<Type> getType(){
		return factoryService.listType();
	}
	
	@RequestMapping("/fetchGoods")
	@ResponseBody
	public List<Goods> fetchGoods(
			@RequestParam(value="brandId",required=false,defaultValue="0")long brandId,
			@RequestParam(value="typeId",required=false,defaultValue="0")long typeId){
		return factoryService.fetchGoodsByBrandAndType(brandId, typeId);
	}
	
	public String addQuantity(@RequestParam("goodsId")long goodsId,
			@RequestParam("quantity")int quantity,
			HttpServletRequest request){
		Market market=(Market) request.getSession().getAttribute("market");
		if(market!=null){
			FactoryItem item=factoryService.createItem(goodsId, market.getId(), quantity);
			boolean isOK=factoryService.saveOrAddFactoryItem(item);
			request.setAttribute("tips",isOK?"添加成功":"添加失败");
		}else{
			request.setAttribute("tips","您可能还未登陆，添加失败");
		}
		return "items/factory/success.jsp";
	}
	
	@RequestMapping("/add")
	public String addItem(
			@RequestParam("goodsId") long goodsId,
			@RequestParam("quantity")int quantity,
			HttpServletRequest request){
		
		Market market=(Market) request.getSession().getAttribute("market");
		if(market!=null){
			FactoryItem factoryItem=factoryService.createItem(goodsId, market.getId(), quantity);
			boolean isOK=factoryService.saveOrAddFactoryItem(factoryItem);
			request.setAttribute("tips", isOK?"成功":"失败");
			return "items/factory/success.jsp";
		}else{
			request.setAttribute("tips","您可能还未登陆，添加失败");
			return "items/factory/success.jsp";
		}
		
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("id") long id,HttpServletRequest request){
		if(factoryService.removeFactoryItem(id)){
			request.setAttribute("factoryItemList", factoryService.fetchFactoryItem((Map<String, Object>) request.getSession().getAttribute("factoryCondition")));
			return "items/factory/list.jsp";
		}else{
			request.setAttribute("tips","删除失败");
			return "items/factory/success.jsp";
		}
	}
}
