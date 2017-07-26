package com.eMarket.model.po;

/**
 * 工作人员对象
 * @author 水保勤
 *
 */
public class Worker {
	private String username;		//用户名
	private String password;		//密码
	private String name;			//姓名
	private String role;			//角色
	private long marketId;			//工作人员所属的商店的id

	//get和set方法
	public String getUsername(){
		return username;
	}
	public long getMarketId() {
		return marketId;
	}
	public void setMarketId(long marketId) {
		this.marketId = marketId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Worker [username=" + username + ", password=" + password + ", name=" + name + ", role=" + role
				+ ", marketId=" + marketId + "]";
	}
}
