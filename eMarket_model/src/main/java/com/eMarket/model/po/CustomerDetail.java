package com.eMarket.model.po;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户详情对象
 * @author 水保勤
 *
 */
public class CustomerDetail {
	private String sex;				//用户性别
	private String image;			//用户照片
	private String address;			//用户地址
	private String tel;				//电话
	private String email;			//邮箱
	private String qq;				//qq
	
	@JsonFormat(pattern="yyyy年MM月dd日 HH:mm:ss")
	private Date createTime;		//创建日期
	private int level;				//用户等级
	private int score;				//用户积分
	
	private Customer customer=new Customer();		//用户

	//构造方法
	public CustomerDetail(String sex, String image, Date createTime, int level, int score,
			Customer customer) {
		super();
		this.sex = sex;
		this.image = image;
		this.createTime = createTime;
		this.level = level;
		this.score = score;
		this.customer = customer;
	}
	public CustomerDetail(String sex, String image, String address, Date createTime, int level, int score,
			Customer customer) {
		super();
		this.sex = sex;
		this.image = image;
		this.address = address;
		this.createTime = createTime;
		this.level = level;
		this.score = score;
		this.customer = customer;
	}
	public CustomerDetail() {
		super();
	}
	
	//get和set方法
	public Customer getCustomer() {
		return customer;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "CustomerDetail [sex=" + sex + ", image=" + image + ", address=" + address + ", createTime=" + createTime
				+ ", level=" + level + ", score=" + score + ", customer=" + customer + "]";
	}
}
