package com.cracker.dao.impl;

import java.util.List;

import com.cracker.bean.Book;
import com.cracker.bean.User;
import com.cracker.dao.BaseDao;
import com.cracker.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public boolean addBook(Book book) {
		String  sql = "insert into bs_book(title, author, price, sales, "
				+ "stock, img_path) values(?,?,?,?,?,?)";
		int update = update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(),
				book.getStock(),book.getImgPath());
		return update > 0;
	}

	@Override
	public boolean delBook(Book book) {
		String sql = "DELETE FROM bs_book WHERE id=? ";
		int update = update(sql, book.getId());
		return update > 0;
	}

	@Override
	public boolean updateBook(Book book) {
		String sql = "UPDATE bs_book SET title=? , author=? , price=? , sales=? , stock=? , img_path=? "
				+ "WHERE id=?";
		//	book 修改后的样子
		int update = update(sql, book.getTitle(), book.getAuthor(),
				book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath(), book.getId());
		return update > 0;
	}

	@Override
	public List<Book> getAllBook() {
		String sql = "SELECT id, title , author , price , sales , stock , img_path imgPath FROM bs_book";
		return getBeanList(sql);
	}

	//获取一本图书
	@Override
	public Book getBook(Book book) {
		String sql = "SELECT id, title , author , price , sales , stock , "
				+ "img_path imgPath FROM bs_book where id=?";
		return getBean(sql, book.getId());
	}

	@Override
	public List<Book> getPageList(int index, int size) {
		String sql = "SELECT id, title , author , price , sales , stock , "
				+ "img_path imgPath FROM bs_book limit ?,?";
		return getBeanList(sql, index, size);
	}
	
	/**
	 * 根据图书价格查询图书
	 * @param index
	 * @param size
	 * @param minPrice	最小价格
	 * @param maxPrice	最大价格
	 * @return
	 */
	@Override
	public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice) {
		String sql = "SELECT id, title , author , price , sales , stock , "
				+ "img_path imgPath FROM bs_book where price between ? and ? limit ?,?";
		return getBeanList(sql, minPrice, maxPrice, index, size);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from bs_book";
		Object object = getSingleValue(sql);
		int parseInt = 0;
		try {
			parseInt = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return parseInt;
	}
	
	/**
	 * 根据图书价格查找出相应的记录数
	 */
	@Override
	public int getTotalCountByPrice(double minPrice, double maxPrice) {
		String sql = "select count(*) from bs_book where price between ? and ?";
		Object object = getSingleValue(sql, minPrice, maxPrice);
		int i = 0;
		try {
			i = Integer.parseInt(object.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}

}
