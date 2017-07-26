package com.emarket.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.condition.BrandSelectCondition;
import com.eMarket.model.po.Brand;
import com.eMarket.model.vo.Result;
import com.emarket.admin.service.BrandManageService;
import com.emarket.dao.BrandDAO;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.LongPrimaryKeyGenerator;

@Service("brandManageService")
public class BrandManageServiceImpl implements BrandManageService{
	
	@Autowired
	private BrandDAO brandDAO;
	
	@Override
	public Brand saveBrand(Brand brand) {
		Brand initBrand = brand.init();
		int i=brandDAO.saveBrand(initBrand);
		return i==1?initBrand:null;
	}

	@Override
	public boolean removeBrand(long id) {
		int i=brandDAO.removeBrand(id);
		return i==1;
	}

	@Override
	public Brand updateBrand(Brand brand){
		int i=brandDAO.update(brand);
		return i==1?brand:null;
	}

	@Override
	public Brand getBrandById(long id) {
		return brandDAO.getBrandById(id);
	}

	@Override
	public List<Brand> fetchBrand(Map<String,Object> condition) {
		return brandDAO.fetchBrands(condition);
	}
	
}
