package com.eMarket.model.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderSelectCondition {
	private Long id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startCreateTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endCreateTime;
	private Float lowestAmount;
	private Float highestAmount;
	private Integer lowestQuantity;
	private Integer highestQuantity;
	private Integer status;
	private Long marketId;
	
	public Float getLowestAmount() {
		return lowestAmount;
	}
	public void setLowestAmount(Float lowestAmount) {
		this.lowestAmount = lowestAmount;
	}
	public Float getHighestAmount() {
		return highestAmount;
	}
	public void setHighestAmount(Float highestAmount) {
		this.highestAmount = highestAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	public Date getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
	public Integer getLowestQuantity() {
		return lowestQuantity;
	}
	public void setLowestQuantity(Integer lowestQuantity) {
		this.lowestQuantity = lowestQuantity;
	}
	public Integer getHighestQuantity() {
		return highestQuantity;
	}
	public void setHighestQuantity(Integer highestQuantity) {
		this.highestQuantity = highestQuantity;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getMarketId() {
		return marketId;
	}
	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> condition=new HashMap<>();
		condition.put("id", id);
		condition.put("startCreateTime", startCreateTime);
		condition.put("endCreateTime",endCreateTime);
		condition.put("lowestAmount",lowestAmount);
		condition.put("highestAmount", highestAmount);
		condition.put("lowestQuantity",lowestQuantity);
		condition.put("highestQuantity", highestQuantity);
		condition.put("status", status);
		condition.put("marketId", marketId);
		return condition;
	}
}
