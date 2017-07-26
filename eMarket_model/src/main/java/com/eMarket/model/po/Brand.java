package com.eMarket.model.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.LongPrimaryKeyGenerator;

/**
 * 商品品牌对象
 * @author
 *
 */
public class Brand{
	
	private final static LengthPrimaryKeyGenerator<Long> generator=new LongPrimaryKeyGenerator();
	
	private long id;			//品牌编号
	private String name;		//品牌名称
	private String country;		//国家名
	
	@JsonFormat(pattern="yyyy年MM月dd日 HH:mm:ss")
	private Date createTime;	//创建时间
	private int level;			//星级
	private String comment;		//备注
	
	//构造方法
	
	public Brand(long id, String name, String country, Date createTime, int level, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.createTime = createTime;
		this.level = level;
		this.comment = comment;
	}
	public Brand(long id) {
		super();
		this.id = id;
	}
	public Brand() {
		super();
	}
	
	//get和set方法
	public long getId() {
		return id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//toString方法
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", country=" + country + ", createTime=" + createTime + ", level="
				+ level + ", comment=" + comment + "]";
	}
	
	public Brand init(){
		Brand brand=new Brand();
		brand.setId(generator.generatePrimaryKey(8));
		brand.setName(name);
		brand.setCountry(country);
		brand.setLevel(level);
		brand.setCreateTime(new Date());
		brand.setComment(comment);
		return brand;
	}
}
