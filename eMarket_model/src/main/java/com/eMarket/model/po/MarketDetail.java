package com.eMarket.model.po;

import java.util.List;

/**
 * 商店详情对象
 * @author 水保勤
 *
 */
public class MarketDetail {
	private String address;							//地址
	private int level;								//星级
	private int type;								//商店类型。1：旗舰店，2：分店
	private int praise;								//口碑
	
	private Market market;							//商店

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	@Override
	public String toString() {
		return "MarketDetail [address=" + address + ", level=" + level + ", type=" + type + ", praise=" + praise
				+ ", market=" + market + "]";
	}
}
