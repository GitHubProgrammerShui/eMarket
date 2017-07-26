package com.eMarket.model.condition;

import java.util.HashMap;
import java.util.Map;

public class WorkerSelectCondition {
	
	private String username;
	private String role;
	private String name;
	private Long marketId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMarketId() {
		return marketId;
	}
	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
	@Override
	public String toString() {
		return "WorkerSelectCondition [username=" + username + ", role=" + role + ", name=" + name + ", marketId="
				+ marketId + "]";
	}

	public Map<String,Object> toMap(){
		Map<String,Object> condition=new HashMap<>();
		if(username!=null&&!"".equals(username)){
			condition.put("username", username);
		}
		if(role!=null&&!"".equals(role)){
			condition.put("role", role);
		}
		if(name!=null&&!"".equals(name)){
			condition.put("name", name);
		}
		condition.put("marketId", marketId);
		return condition;
	}
}
