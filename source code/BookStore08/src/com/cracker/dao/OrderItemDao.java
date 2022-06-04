package com.cracker.dao;

import java.util.Collection;
import java.util.List;

import com.cracker.bean.OrderItem;

/**
 * 操作订单项dao
 * @author chen
 *
 */
public interface OrderItemDao {
	
	/**
	 * 获取某个订单的所有订单项
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);
	
	/**
	 * 保存某个订单项
	 * @param item
	 * @return
	 */
	public int saveOrderItem(OrderItem item);

	public int saveBatch(List<OrderItem> item);
}
