package com.cracker.dao;

import java.util.List;

import com.cracker.bean.Order;

public interface OrderDao {

	/**
	 * 保存订单
	 * @param order
	 * @return
	 */
	public int saveOrder(Order order);

	/**
	 * 修改订单状态
	 * @param order
	 * @return
	 */
	public int updateStatus(Order order);
	
	/**
	 * 获取所有订单（管理员用）
	 * @return
	 */
	public List<Order> getOrderList();
	
	/**
	 * 获取某个用户订单
	 * @param userId
	 * @return
	 */
	public List<Order> getOrderByUserId(Integer userId);
}
