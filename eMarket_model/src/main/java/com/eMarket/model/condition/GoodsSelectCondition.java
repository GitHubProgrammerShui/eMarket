package com.eMarket.model.condition;

import java.util.HashMap;
import java.util.Map;

public class GoodsSelectCondition{
	private Long id;
	private String name;
	private Long brandId;
	private Long typeId;
	private Float lowestPrice;
	private Float highestPrice;
	private byte[] status;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Float getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(Float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
	public Float getHighestPrice() {
		return highestPrice;
	}
	public void setHighestPrice(Float highestPrice) {
		this.highestPrice = highestPrice;
	}
	public byte[] getStatus() {
		return status;
	}
	public void setStatus(byte[] status) {
		this.status = status;
	}

	public Map<String,Object> toMap(){
		Map<String,Object> map=new HashMap<>();
		if(id!=null){
			map.put("id", id);
		}
		if(name!=null){
			map.put("name",name);
		}
		if(brandId!=null){
			map.put("brand_id", brandId);
		}
		if(typeId!=null){
			map.put("type_id", typeId);
		}
		if(lowestPrice!=null){
			map.put("lowestPrice",lowestPrice);
		}
		if(highestPrice!=null){
			map.put("highestPrice", highestPrice);
		}
		if(status!=null){
			map.put("status", status);
		}
		return map;
	}
}
