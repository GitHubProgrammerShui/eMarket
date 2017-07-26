package com.eMarket.model.po;

import java.util.Date;
import java.util.List;
/**
 * 订单对象
 * @author 水保勤
 *
 */
public class Order {
	private long id;				//订单id
	private Date createTime;		//订单创建时间
	private float amount;			//订单总金额
	private int quantity;			//数量
	private int status;				//订单状态。1：待处理，2：已拒绝，3：处理中，4：处理完成，5：客户确认
	
	private Goods goods;			//商品
	private Market market;			//处理商店
	private Customer customer;		//订单所属用户

	//get和set方法
	public long getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", createTime=" + createTime + ", amount=" + amount + ", status=" + status
				+ ", customer=" + customer + "]";
	}
}
