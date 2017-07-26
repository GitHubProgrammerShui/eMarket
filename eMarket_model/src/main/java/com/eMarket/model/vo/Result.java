package com.eMarket.model.vo;

import com.eMarket.model.po.Type;

/**
 * 结果对象，一般用于结果验证
 * @author 水保勤
 *
 */
public class Result{
	private boolean success;
	private String tips;
	private Object data;
	
	public Result() {
		super();
	}
	public Result(boolean success, String tips, Object data) {
		super();
		this.success = success;
		this.tips = tips;
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Result [success=" + success + ", tips=" + tips + ", data=" + data + "]";
	}
	
}
