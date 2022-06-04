package com.cracker.test;

import java.util.List;

import org.junit.Test;

import com.cracker.bean.Book;
import com.cracker.bean.Page;
import com.cracker.dao.BookDao;
import com.cracker.dao.impl.BookDaoImpl;
import com.cracker.service.BookService;
import com.cracker.service.impl.BookServiceImpl;


public class BookDaoTest {
	
	BookDao bd = new BookDaoImpl();
	
	/**
	 * 获取所有图书
	 */
	@Test
	public void test() {
		List<Book> list = bd.getAllBook();
		System.out.println(list);
	}
	
	/**
	 * 添加图书
	 */
	@Test
	public void test2() {
		//创建一个Book对象
		Book book = new Book(null, "java2", "qwe", 20, 12, 12, null);
		boolean b = bd.addBook(book);
		System.out.println(b);
	}
	
	/**
	 * 删除图书
	 */
	@Test
	public void test3() {
		//创建一个Book对象
		Book book = new Book();
		book.setId(2);
		boolean b = bd.delBook(book);
		System.out.println(b);
	}
	
	/**
	 * 修改图书
	 */
	@Test
	public void test4() {
		Book book = new Book(3, "java4", "asd", 20, 20, 20, null);
		boolean b = bd.updateBook(book);
		System.out.println(b);
	}
	
	//获取一本图书
	@Test
	public void test5() {
		Book b = new Book();
		b.setId(4);
		Book book = bd.getBook(b);
		System.out.println(b);
	}
	
	//获取一本图书
	@Test
	public void test6() {
		BookService bs = new BookServiceImpl();
		Page<Book> page = bs.getPage("0", "4");
		System.out.println(page.getPageData());
		System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}
	
	//获取一本图书
	@Test
	public void test7() {
		BookService bs = new BookServiceImpl();
		Page<Book> page = bs.getPageByPriece("1", "4", "100", "50");
		System.out.println(page.getPageData());
		System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}
}
