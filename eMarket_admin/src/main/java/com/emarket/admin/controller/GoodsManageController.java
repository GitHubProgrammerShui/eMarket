package com.emarket.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eMarket.model.po.Brand;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Type;
import com.eMarket.model.vo.GoodsParam;
import com.eMarket.model.vo.Result;
import com.emarket.admin.service.GoodsManageService;
import com.emarket.admin.util.FileNameUtil;
import com.emarket.admin.util.PropsUtil;

/**
 * 商品管理类
 * @author 水保勤
 *
 */
@Controller
@RequestMapping("/admin/goods")
public class GoodsManageController {

	@Autowired
	private GoodsManageService goodsManageService;
	
	@RequestMapping("/showGoods")
	public String showGoods(HttpServletRequest request){
		request.setAttribute("goodsList",goodsManageService.showGoods(new HashMap<String, Object>()));
		return "items/goods/list.jsp";
	}

	@RequestMapping("/fetch")
	public String fetchGoods(@RequestParam(value="name",required=false)String name,
			@RequestParam(value="id",required=false)Long id,
			HttpServletRequest request){
		Map<String,Object> condition=new HashMap<>();
		condition.put("name",name);
		condition.put("id", id);
		
		request.setAttribute("goodsList",goodsManageService.showGoods(condition));
		request.getSession().setAttribute("goodsCondition", condition);
		
		return "items/goods/list.jsp";
	}
	
	@RequestMapping("/save")
	public String saveGoods(GoodsParam param,HttpServletRequest request){
		Goods goods=goodsManageService.saveGoods(param.toGoods());
		if(goods!=null){
			request.setAttribute("tips","添加成功！");
			request.setAttribute("goods",goods);
			System.out.println(request.getAttribute("goods"));
			return "items/goods/success.jsp";
		}else{
			request.setAttribute("tips", "添加失败");
			return "items/goods/saveorupdate.jsp";
		}
	}
	@RequestMapping("/init/{operatrion}")
	public String initSaveOrUpdate(@PathVariable("operatrion")String url,@RequestParam(value="id",required=false)Long id,HttpServletRequest request){
		Map<String,Object> initParams=goodsManageService.init(id);
		request.setAttribute("initParams", initParams);
		request.setAttribute("url","/admin/goods/"+url);
		return "items/goods/saveorupdate.jsp";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public Result upload(@RequestParam("photo") MultipartFile multiFile){
		Result result=new Result();
		Map<String,String> uploadParam=PropsUtil.getMap("goodsImageUploadProfile");
		uploadParam.put("fileName",FileNameUtil.createNewFileName(multiFile.getOriginalFilename()));
		try {
			result=goodsManageService.uploadToFtpServer(uploadParam,multiFile.getInputStream());
		} catch (IOException e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setTips("获取文件流异常");
		}
		return result;
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("id")long id,HttpServletRequest request){
		if (goodsManageService.deleteGoods(id)) {
			request.setAttribute("goodsList", goodsManageService
					.showGoods((Map<String, Object>) request.getSession().getAttribute("goodsCondition")));
		}else{
			request.setAttribute("tips","删除失败");
		}
		return "items/goods/list.jsp";
	}
	
	@RequestMapping("/update")
	public String updateGoods(GoodsParam goodsParam,HttpServletRequest request){
		Goods g=goodsManageService.getGoodsById(goodsParam.getId());
		if(g!=null){
			g.setBrand(new Brand(goodsParam.getBrandId()));
			g.setType(new Type(goodsParam.getTypeId()));
			g.setContent(goodsParam.getContent());
			g.setImage(goodsParam.getImage());
			g.setName(goodsParam.getName());
			g.setPrice(goodsParam.getPrice());
			g.setStatus(goodsParam.getStatus());
			
			g=goodsManageService.updateGoods(g);
			
			if(g!=null){
				request.setAttribute("tips","修改成功");
			}else{
				request.setAttribute("tips","修改失败");
			}
			return "items/goods/success.jsp";
		}else{
			request.setAttribute("tips","未找到指定的商品对象，更新失败");
			return "items/goods/success.jsp";
		}
	}
	
	@RequestMapping("/getDetail")
	public String getDetail(@RequestParam("id")long id,HttpServletRequest request){
		Goods goods=goodsManageService.getGoodsById(id);
		if(goods!=null){
			request.setAttribute("goods", goods);
			return "items/goods/detail.jsp";
		}else{
			request.setAttribute("tips","没有对应的商品");
			return "items/goods/success.jsp";
		}
	}
}