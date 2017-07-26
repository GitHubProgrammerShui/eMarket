package com.eMarket.model.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

public class TypeSelectCondition {
	private Long id;
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date stopTime;
	private String comment;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getStopTime() {
		return stopTime;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "TypeSelectCondition [id=" + id + ", name=" + name + ", startTime=" + startTime + ", stopTime="
				+ stopTime + ", comment=" + comment + "]";
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> condition=new HashMap<>();
		if(id!=null){
			condition.put("id",id);
		}
		if(name!=null){
			condition.put("name", name);
		}
		if(startTime!=null){
			condition.put("startCreateTime", startTime);
		}
		if(stopTime!=null){
			condition.put("stopCreateTime", stopTime);
		}
		if(comment!=null){
			condition.put("comment", comment);
		}
		return condition;
	}
}
