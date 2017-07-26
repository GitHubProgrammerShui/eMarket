package com.eMarket.model.po;

import java.util.Date;
import java.util.List;

/**
 * 库存项POJO对象
 * @author 水保勤
 *
 */
public class FactoryItem{
	private long id;				//库存编号
	private int amount;				//库存数量
	
	private Goods goods;			//商品
	private Market market;			//商店
	
	//构造方法
	public FactoryItem(long id, int amount, Goods goods, Market market) {
		super();
		this.id = id;
		this.amount = amount;
		this.goods = goods;
		this.market = market;
	}
	public FactoryItem() {
		super();
	}
	
	//get和set方法
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	
	@Override
	public String toString(){
		return "FactoryItem [id=" + id + ", amount=" + amount + ", goods=" + goods + ", market=" + market + "]";
	}
}
