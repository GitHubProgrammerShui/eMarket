package com.emarket.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMarket.model.po.Type;
import com.emarket.admin.service.TypeManageService;
import com.emarket.dao.TypeDAO;

@Service("typeManageService")
public class TypeManageServiceImpl implements TypeManageService{

	@Autowired
	private TypeDAO typeDAO;
	
	@Override
	public Type saveType(Type type) {
		int i=typeDAO.saveType(type);
		return i==1?typeDAO.getTypeById(type.getId()):null;
	}

	@Override
	public boolean removeType(long id) {
		int i=typeDAO.removeType(id);
		return i==1;
	}

	@Override
	public Type updateType(Type type) {
		int i=typeDAO.updateType(type);
		return i==1?typeDAO.getTypeById(type.getId()):null;
	}

	@Override
	public Type getTypeById(long id) {
		return typeDAO.getTypeById(id);
	}

	@Override
	public List<Type> fetchType(Map<String,Object> condition) {
		return typeDAO.fetchTypes(condition);
	}
}
