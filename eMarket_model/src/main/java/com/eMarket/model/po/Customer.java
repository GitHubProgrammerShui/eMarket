package com.eMarket.model.po;
/**
 * 用户对象，可用于用户登录验证，在进入商城浏览时，该是用户的唯一身份凭据
 * @author 水保勤
 *
 */
public class Customer {
	private String username;				//用户名
	private String password;				//用户密码
	private String name;					//用户姓名
	private String userType;				//用户类型，1：普通用户，2：超级用户
	
	//get和set方法
	public String getUsername() {
		return username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", name=" + name + ", userType=" + userType
				+ "]";
	}
}
