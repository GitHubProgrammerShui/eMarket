package com.eMarket.model.vo;

import java.util.Date;

import javax.swing.text.AbstractDocument.LeafElement;

import com.eMarket.model.po.Brand;
import com.eMarket.model.po.Goods;
import com.eMarket.model.po.Type;
import com.shui.generator.LengthPrimaryKeyGenerator;
import com.shui.generator.impl.LongPrimaryKeyGenerator;

public class GoodsParam{

	private final static LengthPrimaryKeyGenerator<Long> generator=new LongPrimaryKeyGenerator();
	
	private long id;

	private String name;
	private String image;
	private float price;
	private byte status;
	private long typeId;
	private long brandId;
	private String content;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	
	public Goods toGoods(){
		Goods goods=new Goods();
		goods.setId(generator.generatePrimaryKey(8));
		goods.setName(name);
		goods.setPrice(price);
		goods.setStatus(status);
		goods.setImage(image);
		goods.setCreateTime(new Date());
		goods.setContent(content);
		goods.setType(new Type(typeId,null,null,null));
		goods.setBrand(new Brand(brandId,null,null,null,0,null));
		return goods;
	}
}
