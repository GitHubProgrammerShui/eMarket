package com.emarket.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMarket.model.condition.BrandSelectCondition;
import com.eMarket.model.po.Brand;
import com.emarket.admin.service.BrandManageService;

@Controller
@RequestMapping("/admin/brand")
public class BrandManageController {

	@Autowired
	private BrandManageService brandService;
	
	@RequestMapping("/fetch")
	public String list(BrandSelectCondition condition,HttpServletRequest request){
		List<Brand> brandList=brandService.fetchBrand(condition.toMap());
		request.setAttribute("brandList",brandList);
		request.getSession().setAttribute("brandCondition",condition.toMap());
		if(brandList.isEmpty()){
			request.setAttribute("tips","没有找到满足条件的结果");
		}
		return "items/brand/list.jsp";
	}
	
	@RequestMapping("/save")
	public String saveBrand(Brand brand,HttpServletRequest request){
		brand=brandService.saveBrand(brand);
		request.setAttribute("tips",brand!=null?"添加成功":"添加失败");
		return "items/brand/success.jsp";
	}
	
	@RequestMapping("/initUpdate")
	public String initUpdate(@RequestParam("id")long id,HttpServletRequest request){
		request.setAttribute("brand",brandService.getBrandById(id));
		return "items/brand/update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Brand brand,HttpServletRequest request){
		Brand b=brandService.getBrandById(brand.getId());
		b.setName(brand.getName());
		b.setLevel(brand.getLevel());
		b.setCountry(brand.getCountry());
		b.setComment(brand.getComment());
		b=brandService.updateBrand(b);
		request.setAttribute("tips",brand!=null?"修改成功":"修改失败");
		request.setAttribute("brand", b);
		return "items/brand/success.jsp";
	}
	
	@RequestMapping("/remove")
	public String removeBrand(@RequestParam("id")long id,HttpServletRequest request){
		if(brandService.removeBrand(id)){
			request.setAttribute("brandList", brandService.fetchBrand((Map<String, Object>) request.getSession().getAttribute("brandCondition")));
			return "items/brand/list.jsp";
		}else{
			request.setAttribute("tips","删除失败");
			return "items/brand/success.jsp";
		}
	}
}
