package com.eMarket.model.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 品牌查询条件对象
 * @author 水保勤
 *
 */
public class BrandSelectCondition{

	private Long id;
	private String name;
	private Integer lowestLevel;
	private Integer highestLevel;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startCreateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date stopCreateTime;
	
	private String country;
	
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
	public Integer getLowestLevel() {
		return lowestLevel;
	}
	public void setLowestLevel(Integer lowestLevel) {
		this.lowestLevel = lowestLevel;
	}
	public Integer getHighestLevel() {
		return highestLevel;
	}
	public void setHighestLevel(Integer highestLevel) {
		this.highestLevel = highestLevel;
	}
	public Date getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	public Date getStopCreateTime() {
		return stopCreateTime;
	}
	public void setStopCreateTime(Date stopCreateTime) {
		this.stopCreateTime = stopCreateTime;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "BrandSelectCondition [id=" + id + ", name=" + name + ", lowestLevel=" + lowestLevel + ", highestLevel="
				+ highestLevel + ", startCreateTime=" + startCreateTime + ", stopCreateTime=" + stopCreateTime
				+ ", country=" + country + "]";
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> condition=new HashMap<>();
		
		if(id!=null){
			condition.put("id", id);
		}
		if(name!=null){
			condition.put("name", name);
		}
		if(lowestLevel!=null){
			condition.put("lowestLevel", lowestLevel);
		}
		if(highestLevel!=null){
			condition.put("highestLevel", highestLevel);
		}
		if(startCreateTime!=null){
			condition.put("startCreateTime", startCreateTime);
		}
		if(stopCreateTime!=null){
			condition.put("lastCreateTime",stopCreateTime);
		}
		if(country!=null){
			condition.put("country", country);
		}
		
		return condition;
	}
}
