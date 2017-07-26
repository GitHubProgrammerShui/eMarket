package com.emarket.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eMarket.model.condition.TypeSelectCondition;
import com.eMarket.model.po.Type;
import com.emarket.admin.service.TypeManageService;

@Controller
@RequestMapping("/admin/type")
public class TypeManageController {
	
	@Autowired
	private TypeManageService typeService;
	
	@RequestMapping("/save")
	public String saveType(Type type,HttpServletRequest request){
		Type finalType=typeService.saveType(type.init());
		if(finalType!=null){
			request.setAttribute("tips","添加成功");
			request.setAttribute("result",finalType);
			return "items/type/success.jsp";
		}else{
			request.setAttribute("tips","添加失败");
			return "items/type/saveorupdate.jsp";
		}
	}
	
	@RequestMapping("/initUpdate")
	public String initUpdate(@RequestParam("id")long id,HttpServletRequest request) {
		request.setAttribute("type",typeService.getTypeById(id));
		return "items/type/update.jsp";
	}
	
	@RequestMapping("/update")
	public String update(Type type,HttpServletRequest request){
		Type t=typeService.getTypeById(type.getId());
		if(t!=null){
			t.setName(type.getName());
			t.setComment(type.getComment());
			t=typeService.updateType(t);
			if(t!=null){
				request.setAttribute("tips","更新成功");
				return "items/type/success.jsp";
			}else{
				request.setAttribute("tips","更新失败");
				return "items/type/success.jsp";
			}
		}else{
			request.setAttribute("tips","未找到指定的类型，更新失败");
			return "items/type/success.jsp";
		}
	}
	
	@RequestMapping("/fetch")
	public String fetchType(TypeSelectCondition condition,HttpServletRequest request){
		List<Type> typeList=typeService.fetchType(condition.toMap());
		request.setAttribute("typeList", typeList);
		request.getSession().setAttribute("typeCondition",condition.toMap());
		if(typeList.isEmpty()){
			request.setAttribute("tips", "未找到满足条件的记录");
		}
		return "items/type/list.jsp";
	}
	
	@RequestMapping("/remove")
	public String removeType(@RequestParam("id")long id,HttpServletRequest request){
		if(typeService.removeType(id)){
			request.setAttribute("typeList", typeService.fetchType((Map<String, Object>) request.getSession().getAttribute("typeCondition")));
			request.setAttribute("tips","删除成功");
			return "items/type/list.jsp";
		}else{
			request.setAttribute("tips","删除失败");
			return "items/type/success.jsp";
		}
	}
}
