package com.eMarket.model.po;

import java.util.Date;

import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.LongPrimaryKeyGenerator;

/**
 * 商品类型对象
 * @author shuibaoqin
 *
 */
public class Type {
	
	private final static LengthPrimaryKeyGenerator<Long> generator=new LongPrimaryKeyGenerator();
	
	private long id;
	private String name;
	private Date createTime;
	private String comment;

	//构造方法
	public Type(long id, String name, Date createTime, String comment) {
		super();
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.comment = comment;
	}
	public Type(long id) {
		super();
		this.id = id;
	}
	public Type(){
		super();
	}
	
	//get和set方法
	public long getId(){
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		return "Type [id=" + id + ", name=" + name + ", createTime=" + createTime + ", comment=" + comment + "]";
	}
	
	public Type init(){
		Type type=new Type();
		type.setId(generator.generatePrimaryKey(8));
		type.setCreateTime(new Date());
		type.setName(name);
		type.setComment(comment);
		return type;
	}
}
