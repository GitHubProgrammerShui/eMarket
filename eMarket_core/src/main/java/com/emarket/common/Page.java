package com.emarket.common;

import java.util.List;

public class Page<T>{
	
	private int pageSize;
	private int pageNum;
	private int pageAmount;
	private int fetchedAmount;
	private List<T> content;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageAmount() {
		return pageAmount;
	}
	public void setPageAmount(int pageAmount) {
		this.pageAmount = pageAmount;
	}
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getFetchedAmount() {
		return fetchedAmount;
	}
	public void setFetchedAmount(int fetchedAmount) {
		this.fetchedAmount = fetchedAmount;
	}
	
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNum=" + pageNum + ", pageAmount=" + pageAmount + ", fetchedAmount="
				+ fetchedAmount + ", content=" + content + "]";
	}
}
