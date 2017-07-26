package com.eMarket.model.vo;

import java.util.Date;

import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.StringPrimaryKeyGenerator;

/**
 * 用于接收来自前端页面提交过来的工作人员详情信息
 * @author 水保勤
 *
 */
public class WorkerParam{
	
	private String username;
	private String password;
	private String name;
	private String role;
	private long marketId;
	
	private float reward;
	private Date registerTime;
	private String comment;
	private String image;
	private String sex;
	private int age;
	private String idCard;
	private String address;
	private String accountCardNo;
	private String tel;
	private String email;
	private String qq;
	
	public String getUsername() {
		return username;
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
	public long getMarketId() {
		return marketId;
	}
	public void setMarketId(long marketId) {
		this.marketId = marketId;
	}
	public float getReward() {
		return reward;
	}
	public void setReward(float reward) {
		this.reward = reward;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountCardNo() {
		return accountCardNo;
	}
	public void setAccountCardNo(String accountCardNo) {
		this.accountCardNo = accountCardNo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Override
	public String toString() {
		return "WorkerParam [username=" + username + ", password=" + password + ", name=" + name + ", role=" + role
				+ ", marketId=" + marketId + ", reward=" + reward + ", registerTime=" + registerTime + ", comment="
				+ comment + ", image=" + image + ", sex=" + sex + ", age=" + age + ", idCard=" + idCard + ", address="
				+ address + ", accountCardNo=" + accountCardNo + ", tel=" + tel + ", email=" + email + ", qq=" + qq
				+ "]";
	}
}