package com.emarket.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eMarket.model.condition.WorkerSelectCondition;
import com.eMarket.model.po.Market;
import com.eMarket.model.po.Worker;
import com.eMarket.model.po.WorkerDetail;
import com.eMarket.model.vo.Result;
import com.eMarket.model.vo.WorkerParam;
import com.emarket.admin.service.WorkerManageSerivce;
import com.emarket.admin.util.FileNameUtil;
import com.emarket.admin.util.PropsUtil;

@Controller
@RequestMapping("/admin/worker")
public class WorkerManageController{
	
	@Autowired
	private WorkerManageSerivce workerManageSerivce;
	
	@RequestMapping("/fetch")
	public String fetchWorker(WorkerSelectCondition condition,HttpServletRequest request){
		Map<String,Object> result=new HashMap<>();
		//管理员只能搜索本商店中的所有人员
		Market market=(Market) request.getSession().getAttribute("market");
		Map<String, Object> map = condition.toMap();
		map.put("marketId",market.getId());
		List<Worker> list=workerManageSerivce.fetchWorker(map);
		request.getSession().setAttribute("workerCondition",map);
		result.put("workerList", list);
		request.setAttribute("fetchResult",result);
		return "items/worker/list.jsp";
	}
	
	@RequestMapping("/add")
	public String addWorker(WorkerParam param,HttpServletRequest request){
		Market market=(Market) request.getSession().getAttribute("market");
		param.setMarketId(market.getId());
		WorkerDetail workerDetail=workerManageSerivce.saveWorker(param);
		if(workerDetail!=null){
			request.setAttribute("tips", "添加成功");
			request.setAttribute("workerDetail", workerDetail);
		}
		return "items/worker/success.jsp";
	}
	
	@RequestMapping("/update")
	public String updateWorker(WorkerParam workerParam,HttpServletRequest request){
		WorkerDetail detail=workerManageSerivce.updateWorkerDetail(workerParam);
		if(detail!=null){
			request.setAttribute("workerDetail", detail);
			request.setAttribute("tips","更新成功");
		}else{
			request.setAttribute("tips","更新失败");
		}
		return "items/worker/success.jsp";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public Result upload(@RequestParam("photo") MultipartFile multipartFile){
		Result result=new Result();
		Map<String,String> uploadParam=PropsUtil.getMap("workerImageUploadProfile");
		uploadParam.put("fileName",FileNameUtil.createNewFileName(multipartFile.getOriginalFilename()));
		try {
			result=workerManageSerivce.uploadToFtpServer(uploadParam,multipartFile.getInputStream());
		} catch (IOException e){
			e.printStackTrace();
			result.setSuccess(false);
			result.setTips("获取文件流异常");
		}
		return result;
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam("username")String username,HttpServletRequest request){
		if(workerManageSerivce.removeWorker(username)){
			List<Worker> fetchWorker = workerManageSerivce.fetchWorker((Map<String, Object>) request.getSession().getAttribute("workerCondition"));
			Map<String, Object> fetchResult=new HashMap<>();
			fetchResult.put("worker",fetchWorker);
			request.setAttribute("workerList",fetchWorker);
			request.setAttribute("tips","删除成功");
			return "items/worker/list.jsp";
		}else{
			request.setAttribute("tips","删除失败");
			return "items/worker/success.jsp";
		}
	}
	
	@RequestMapping("/initUpdate")
	public String initUpdate(@RequestParam("username")String username,HttpServletRequest request){
		request.setAttribute("workerDetail",workerManageSerivce.getWorkerDetailByUsername(username));
		return "items/worker/update.jsp";
	}
	
	@RequestMapping("/getDetail")
	public String getDetail(@RequestParam("username")String username,HttpServletRequest request){
		request.setAttribute("workerDetail",workerManageSerivce.getWorkerDetailByUsername(username));
		return "items/worker/success.jsp";
	}
}
