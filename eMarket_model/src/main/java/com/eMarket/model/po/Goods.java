package com.eMarket.model.po;

import java.util.Date;

/**
 * 商品对象
 * @author 水保勤
 *
 */
public class Goods{
	private long id;						//商品编号
	private String name;					//商品名称
	private String image;					//商品图片
	private float price;					//商品价格
	private byte status;					//商品状态。1：普通，2：打折，3：特卖，4：售完
	private Date createTime;				//商品添加时间
	private String content;					//备注
	
	private Brand brand;					//商品品牌
	private Type type;						//商品类型
	
	
	//get和set方法
	public long getId(){
		return id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand){
		this.brand = brand;
	}
	public Type getType(){
		return type;
	}
	public void setType(Type type){
		this.type = type;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", status=" + status
				+ ", createTime=" + createTime + ", content=" + content + ", brand=" + brand + ", type=" + type + "]";
	}
}
