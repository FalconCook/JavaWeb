package com.cracker.service;

import java.util.List;

import com.cracker.bean.Book;
import com.cracker.bean.Page;

/**
 * 图书业务逻辑
 * @author chen
 *
 */
public interface BookService {
	/**
	 * 添加图书
	 * @param book
	 * @return
	 */
	public boolean add(Book book);
	
	/**
	 * 修改图书
	 * @param book
	 * @return
	 */
	public boolean update(Book book);
	
	/**
	 * 删除图书
	 * @param book
	 * @return
	 */
	public boolean delete(Book book);
	
	/**
	 * 删除图书
	 * @param book
	 * @return
	 */
	public Book getOne(Book book);
	
	/**
	 * 获取所有图书
	 * @return
	 */
	public List<Book> getAll();
	
	/**
	 * 返回分页数据
	 */
	public Page<Book> getPage(String pageNo, String  pageSize);

	Page<Book> getPageByPriece(String pageNo, String pageSize, String maxPrice, String minPrice);
}
