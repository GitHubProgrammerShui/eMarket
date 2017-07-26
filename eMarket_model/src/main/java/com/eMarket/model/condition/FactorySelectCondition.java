package com.eMarket.model.condition;

import java.util.HashMap;
import java.util.Map;

public class FactorySelectCondition {
	
	private Long id;
	private Integer lowestAmount;
	private Integer highestAmount;
	private String goodsName;
	private String marketId;
	
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getLowestAmount() {
		return lowestAmount;
	}
	public void setLowestAmount(Integer lowestAmount) {
		this.lowestAmount = lowestAmount;
	}
	public Integer getHighestAmount() {
		return highestAmount;
	}
	public void setHighestAmount(Integer highestAmount) {
		this.highestAmount = highestAmount;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	
	@Override
	public String toString() {
		return "FactorySelectCondition [id=" + id + ", lowestAmount=" + lowestAmount + ", highestAmount="
				+ highestAmount + ", goodsName=" + goodsName + "]";
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> condition=new HashMap<>();
		condition.put("id",id);
		condition.put("lowestAmount", lowestAmount);
		condition.put("highestAmount",highestAmount);
		condition.put("goodsName",goodsName);
		condition.put("marketId",marketId);
		return condition;
	}
}
