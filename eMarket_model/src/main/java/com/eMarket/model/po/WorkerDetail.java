package com.eMarket.model.po;

import java.util.Date;

/**
 * 工作人员详情对象
 * @author 水保勤
 *
 */
public class WorkerDetail{
	private float reward;							//工资
	private Date registerTime;						//注册时间
	private String comment;							//备注
	private String image;							//照片
	private String sex;								//性别
	private int age;								//年龄
	private String idCard;							//身份证号
	private String address;							//住址
	private String accountCardNo;					//银行卡号
	private String tel;								//电话号码
	private String email;							//电子邮箱地址
	private String qq;								//QQ号
	
	private Worker worker;
	
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
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
		return "WorkerDetail [reward=" + reward + ", registerTime=" + registerTime + ", comment=" + comment + ", image="
				+ image + ", sex=" + sex + ", age=" + age + ", idCard=" + idCard + ", address=" + address
				+ ", accountCardNo=" + accountCardNo + ", tel=" + tel + ", email=" + email + ", qq=" + qq + ", worker="
				+ worker + "]";
	}
}
