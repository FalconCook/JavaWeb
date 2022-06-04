package com.cracker.dao;

import java.util.List;

import com.cracker.bean.Book;

/**
 * 定义图书数据库相关操作的接口
 * @author
 *
 */
public interface BookDao {
	
	/**
	 * 添加一本图书
	 * @param book	传入要添加的图书
	 * @return
	 */
	public boolean addBook(Book book);
	
	/**
	 * 删除一本图书
	 * @param bookId
	 * @return
	 */
	public boolean delBook(Book book);
	
	/**
	 * 更新一本图书
	 * @param book 修改后的book
	 * @return
	 */
	public boolean updateBook(Book book);
	
	/**
	 * 获取所有图书
	 * @return
	 */
	public List<Book> getAllBook();
	
	/**
	 * 根据id获取一本图书
	 * @param bookId
	 * @return
	 */
	public Book getBook(Book book);
	
	
	/**
	 * 分页查找图书
	 * @param page
	 * @return
	 */
	public List<Book> getPageList(int index,int size);
	
	/**
	 * 获取所有图书的记录数
	 * @return
	 */
	public int getTotalCountByPrice(double minPrice, double maxPrice);

	/**
	 * 获取所有图书的记录数
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 按照价格查找图书
	 * @param index
	 * @param size
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice);

}
