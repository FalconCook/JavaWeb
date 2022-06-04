package com.cracker.test;

import org.junit.Test;

import com.cracker.bean.Book;
import com.cracker.bean.Cart;
import com.cracker.bean.User;
import com.cracker.service.BookService;
import com.cracker.service.OrderService;
import com.cracker.service.impl.BookServiceImpl;
import com.cracker.service.impl.OrderServiceImpl;

public class OrderServiceTest {
	BookService bookService = new BookServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	
	@Test
	public void test() {
		Book book = new Book();
		book.setId(7);
		Book one = bookService.getOne(book);
		Cart cart = new Cart();
		cart.addBook2Cart(one);
		cart.addBook2Cart(one);
		
		String orderid = orderService.checkout(cart, new User(1, "", "", ""));
		System.out.println(orderid);
	}
}
