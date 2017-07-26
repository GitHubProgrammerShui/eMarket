package com.emarket.admin.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.Worker;
import com.eMarket.model.po.WorkerDetail;
import com.eMarket.model.vo.Result;
import com.eMarket.model.vo.WorkerParam;
import com.emarket.admin.service.WorkerManageSerivce;
import com.emarket.dao.WorkerDAO;
import com.emarket.dao.WorkerDetailDAO;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.StringPrimaryKeyGenerator;

@Service("workerManageService")
public class WorkerManageServiceImpl implements WorkerManageSerivce{

	@Autowired
	private WorkerDAO workerDAO;
	@Autowired
	private FTPClient ftpClient;

	private LengthPrimaryKeyGenerator<String> generator=new StringPrimaryKeyGenerator();
	
	@Override
	public WorkerDetail saveWorker(WorkerParam workerParam){
		WorkerDetail workerDetail=createWorkerDetail(workerParam);
		int i=workerDAO.saveWorkerDetail(workerDetail);
		if(i==1){
			return workerDetail;
		}else{
			return null;
		}
	}

	@Override
	public boolean removeWorker(String username){
		return workerDAO.removeWorkerDetail(username)==1;
	}

	@Override
	public boolean updateWorker(WorkerDetail workerDetail){
		return workerDAO.updateWorkerDetail(workerDetail)==1;
	}

	@Override
	public Worker getWorkerByUsername(String username) {
		return workerDAO.getWorkerByUsername(username);
	}
	
	@Override
	public List<Worker> fetchWorker(Map<String, Object> condition) {
		if(condition==null){
			condition=new HashMap<>();
		}
		return workerDAO.fetchWorker(condition);
	}
	
	/**
	 * 创建WorkerDetail对象
	 * @param workerParam
	 * @return
	 */
	@Override
	public WorkerDetail createWorkerDetail(WorkerParam workerParam){
		WorkerDetail workerDetail=new WorkerDetail();
		
		Worker worker = new Worker();
		worker.setUsername(generator.generatePrimaryKey(9));
		worker.setName(workerParam.getName());
		worker.setPassword(workerParam.getPassword());
		worker.setRole(workerParam.getRole());
		worker.setMarketId(workerParam.getMarketId());
		
		workerDetail.setWorker(worker);
		workerDetail.setAccountCardNo(workerParam.getAccountCardNo());
		workerDetail.setAddress(workerParam.getAddress());
		workerDetail.setAge(workerParam.getAge());
		workerDetail.setComment(workerParam.getComment());
		workerDetail.setEmail(workerParam.getEmail());
		workerDetail.setIdCard(workerParam.getIdCard());
		workerDetail.setImage(workerParam.getImage());
		workerDetail.setQq(workerParam.getQq());
		workerDetail.setRegisterTime(new Date());
		workerDetail.setReward(workerParam.getReward());
		workerDetail.setSex(workerParam.getSex());
		workerDetail.setTel(workerParam.getTel());
		return workerDetail;
	}
	
	@Override
	public WorkerDetail updateWorkerDetail(WorkerParam workerParam){
		WorkerDetail workerDetail=workerDAO.getWorkerDetailByUsername(workerParam.getUsername());
		if(workerDetail!=null){
			workerDetail.getWorker().setName(workerParam.getName());
			workerDetail.getWorker().setPassword(workerParam.getPassword());
			workerDetail.getWorker().setRole(workerParam.getRole());
			workerDetail.setAccountCardNo(workerParam.getAccountCardNo());
			workerDetail.setAddress(workerParam.getAddress());
			workerDetail.setAge(workerParam.getAge());
			workerDetail.setComment(workerParam.getComment());
			workerDetail.setEmail(workerParam.getEmail());
			workerDetail.setIdCard(workerParam.getIdCard());
			workerDetail.setImage(workerParam.getImage());
			workerDetail.setQq(workerParam.getQq());
			workerDetail.setReward(workerParam.getReward());
			workerDetail.setSex(workerParam.getSex());
			workerDetail.setTel(workerParam.getTel());
			int i=workerDAO.updateWorkerDetail(workerDetail);
			return i==1?workerDetail:null;
		}else{
			return null;
		}
	}

	@Override
	public Result uploadToFtpServer(Map<String,String> params, InputStream uploadStream){
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

	@Override
	public WorkerDetail getWorkerDetailByUsername(String username) {
		return workerDAO.getWorkerDetailByUsername(username);
	}
}
