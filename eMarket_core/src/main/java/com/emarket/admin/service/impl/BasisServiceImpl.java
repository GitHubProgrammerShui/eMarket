package com.emarket.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.Market;
import com.eMarket.model.po.Worker;
import com.emarket.admin.service.BasisService;
import com.emarket.dao.MarketDAO;
import com.emarket.dao.WorkerDAO;

@Service("basisService")
public class BasisServiceImpl implements BasisService {
	
	@Autowired
	private WorkerDAO workerDAO;
	@Autowired
	private MarketDAO marketDAO;
	
	@Override
	public Worker login(String username, String password){
		Worker worker=workerDAO.getWorkerByUsername(username);
		if(worker!=null){
			if(worker.getPassword()!=null&&worker.getPassword().equals(password)){
				return worker;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public Market getMarketById(long id){
		return marketDAO.getMarketById(id);
	}

}
