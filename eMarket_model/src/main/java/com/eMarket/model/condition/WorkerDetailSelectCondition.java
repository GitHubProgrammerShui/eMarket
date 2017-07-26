package com.eMarket.model.condition;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WorkerDetailSelectCondition {
	private String username;
	private Float lowestReward;
	private Float highestReward;
	private Date startRegisterTime;
	private Date stopRegisterTime;
	private String comment;
	private String sex;
	private Integer lowestAge;
	private Integer highestAge;
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
	public Float getLowestReward() {
		return lowestReward;
	}
	public void setLowestReward(Float lowestReward) {
		this.lowestReward = lowestReward;
	}
	public Float getHighestReward() {
		return highestReward;
	}
	public void setHighestReward(Float highestReward) {
		this.highestReward = highestReward;
	}
	public Date getStartRegisterTime() {
		return startRegisterTime;
	}
	public void setStartRegisterTime(Date startRegisterTime) {
		this.startRegisterTime = startRegisterTime;
	}
	public Date getStopRegisterTime() {
		return stopRegisterTime;
	}
	public void setStopRegisterTime(Date stopRegisterTime) {
		this.stopRegisterTime = stopRegisterTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getLowestAge() {
		return lowestAge;
	}
	public void setLowestAge(Integer lowestAge) {
		this.lowestAge = lowestAge;
	}
	public Integer getHighestAge() {
		return highestAge;
	}
	public void setHighestAge(Integer highestAge) {
		this.highestAge = highestAge;
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
		return "WorkerDetailSelectCondition [username=" + username + ", lowestReward=" + lowestReward
				+ ", highestReward=" + highestReward + ", startRegisterTime=" + startRegisterTime
				+ ", stopRegisterTime=" + stopRegisterTime + ", comment=" + comment + ", sex=" + sex + ", lowestAge="
				+ lowestAge + ", highestAge=" + highestAge + ", idCard=" + idCard + ", address=" + address
				+ ", accountCardNo=" + accountCardNo + ", tel=" + tel + ", email=" + email + ", qq=" + qq + "]";
	}
	
	public Map<String,Object> toMap(){
		Map<String,Object> condition=new HashMap<>();
		condition.put("username", username);
		condition.put("lowestReward", lowestReward);
		condition.put("highestReward", highestReward);
		condition.put("startRegisterTime", startRegisterTime);
		condition.put("stopRegisterTime", stopRegisterTime);
		condition.put("comment", comment);
		condition.put("sex",sex);
		condition.put("lowestAge", lowestAge);
		condition.put("highestAge", highestAge);
		condition.put("idCard", idCard);
		condition.put("address", address);
		condition.put("accountCardNo",accountCardNo);
		condition.put("tel", tel);
		condition.put("email", email);
		condition.put("qq", qq);
		return condition;
	}
}
