package com.eMarket.model.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 商品评论对象
 * @author shuibaoqin
 *
 */
public class Comment{
	private long id;						//评论编号
	
	@JsonFormat(pattern="yyyy年MM月dd日 HH:mm:ss")
	private Date createTime;				//评论日期
	private Customer customer=new Customer();				//评论人
	private String content;					//评论内容
	private String commentType;				//评论类型 -1：差评，0：中评，1：好评
	
	//构造方法
	public Comment(long id, Date createTime, Customer customer, String content, String commentType){
		super();
		this.id = id;
		this.createTime = createTime;
		this.customer = customer;
		this.content = content;
		this.commentType = commentType;
	}
	public Comment() {
		super();
	}

	//get和set方法
	public long getId(){
		return id;
	}
	public void setId(long id){
		this.id = id;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	public Customer getCustomer(){
		return customer;
	}
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentType() {
		return commentType;
	}
	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

	//toString方法
	@Override
	public String toString() {
		return "Comment [id=" + id + ", createTime=" + createTime + ", customer=" + customer + ", content=" + content
				+ ", commentType=" + commentType + "]";
	}
}
