package com.cracker.bean;

import java.util.Date;

public class Order {
	
	private String orderId;// 订单号
	private Date createDate;// 创建日期
	private double totalMoney;// 订单总额
	private int status;// 订单状态
	private Integer userId;// 用户编号
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Order() {
		super();
	}
	public Order(String orderId, Date createDate, double totalMoney, int status, Integer userId) {
		super();
		this.orderId = orderId;
		this.createDate = createDate;
		this.totalMoney = totalMoney;
		this.status = status;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", createDate=" + createDate + ", totalMoney=" + totalMoney + ", status="
				+ status + ", userId=" + userId + "]";
	}

}
