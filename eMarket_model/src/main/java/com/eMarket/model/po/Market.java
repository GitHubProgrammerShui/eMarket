package com.eMarket.model.po;

public class Market{
	private long id;				//商店编号
	private String name;			//商店名称
	private int status;				//商店状态  1：正常营业，2：休息中，3：暂停营业，4：停止营业

	//构造函数
	public Market(long id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	public Market() {
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	//toString方法
	@Override
	public String toString() {
		return "Market [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
}
