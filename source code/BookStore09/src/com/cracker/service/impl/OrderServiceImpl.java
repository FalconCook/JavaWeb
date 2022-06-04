package com.cracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cracker.bean.Book;
import com.cracker.bean.Cart;
import com.cracker.bean.CartItem;
import com.cracker.bean.Order;
import com.cracker.bean.OrderItem;
import com.cracker.bean.User;
import com.cracker.dao.OrderDao;
import com.cracker.dao.impl.OrderDaoImpl;
import com.cracker.service.BookService;
import com.cracker.service.OrderItemService;
import com.cracker.service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao orderDao = new OrderDaoImpl();
	OrderItemService itemService = new OrderItemServiceImpl();
	BookService bookService = new BookServiceImpl();
	
	@Override
	public String checkout(Cart cart, User user) {
		// 1、封装订单对象
		// orderId需要使用算法生成
		long millis = System.currentTimeMillis();
		// 生成订单号
		String orderId = millis + "" + user.getId();
		Order order = new Order();
		order.setCreateDate(new Date());
		order.setOrderId(orderId);
		order.setTotalMoney(cart.getTotalMoney());
		order.setStatus(0);
		order.setUserId(user.getId());

		// 2、封装订单项对象
		List<CartItem> allItems = cart.getAllItems();
		//保存所有订单项
		List<OrderItem> orderItems = new ArrayList<>();
		for (CartItem cartItem : allItems) {
			//封装一个订单项
			OrderItem item = new OrderItem(cartItem.getBook().getTitle(), 
					cartItem.getCount(), cartItem.getBook().getPrice(), 
					cartItem.getTotalPrice(), orderId);
			orderItems.add(item);
		}
		
		// 3、保存订单
		orderDao.saveOrder(order);
		// 4、保存所有订单项
		itemService.saveItem(orderItems);
		// 5、修改相应库存，改图书，每一项
		for (CartItem cartItem : allItems) {
			//获取详细信息，图书的信息应该从数据库得到
			Book book = cartItem.getBook();
			Book one = bookService.getOne(book);
			//修改库存和销量
			int count = cartItem.getCount();
			one.setStock(one.getStock()-count);
			one.setSales(one.getSales()+count);
			//更新信息
			bookService.update(one);
		}
		//6、清空购物车
		cart.clear();
		
		return orderId;
	}

	@Override
	public void updateStatus(String orderid, String status) {
		Order order = new Order();
		order.setOrderId(orderid);
		int parseInt = 0;
		try {
			parseInt = Integer.parseInt(status);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		order.setStatus(parseInt);
		orderDao.updateStatus(order);
	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.getOrderList();
	}

	@Override
	public List<Order> getMyOrders(Integer userId) {
		return orderDao.getOrderByUserId(userId);
	}

}
