package com.cracker.service.impl;

import java.util.List;

import com.cracker.bean.OrderItem;
import com.cracker.dao.OrderItemDao;
import com.cracker.dao.impl.OrderItemDaoImpl;
import com.cracker.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	
	OrderItemDao itemDao = new OrderItemDaoImpl();
	
	@Override
	public void saveItem(List<OrderItem> orderItem) {
		itemDao.saveBatch(orderItem);
	}

	@Override
	public List<OrderItem> getOrderItems(String orderid) {
		return itemDao.getOrderItems(orderid);
	}

}
