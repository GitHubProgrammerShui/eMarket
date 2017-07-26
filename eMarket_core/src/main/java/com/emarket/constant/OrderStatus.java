package com.emarket.constant;

public class OrderStatus {
	
	/**
	 * 创建订单成功
	 */
	public final static int USER_CREATE_SUCCESS=0;
	/**
	 * 用户已取消该订单
	 */
	public final static int USER_CANCEL=1;
	/**
	 * 工作人员已处理该订单
	 */
	public final static int WORKER_DEALED=2;
	/**
	 * 工作人员拒绝此订单
	 */
	public final static int WORKER_REFUSED=3;
	/**
	 * 订单处理完成
	 */
	public final static int ORDER_COMPLETE=4;
	/**
	 * 订单处理失败
	 */
	public final static int ORDER_FAILURE=5;
}
