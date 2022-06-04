package com.cracker.service.impl;

import java.util.List;

import com.cracker.bean.Book;
import com.cracker.bean.Page;
import com.cracker.dao.BookDao;
import com.cracker.dao.impl.BookDaoImpl;
import com.cracker.service.BookService;

public class BookServiceImpl implements BookService {
	
	private BookDao bd = new BookDaoImpl();
	
	//添加图书
	@Override
	public boolean add(Book book) {
		return bd.addBook(book);
	}

	@Override
	public boolean update(Book book) {
		return bd.updateBook(book);
	}

	@Override
	public boolean delete(Book book) {
		return bd.delBook(book);
	}

	@Override
	public Book getOne(Book book) {
		return bd.getBook(book);
	}

	@Override
	public List<Book> getAll() {
		return bd.getAllBook();
	}

	/**
	 * 获取分页数据
	 */
	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		//1、将用户传入的数据先封装部分
		Page<Book> page = new Page<Book>();
		//将用户传入的数据转型并封装
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		//2、因为要使用totalCount也即是当前总记录数，所以还需要查数据库
		//先要设置页面大小
		page.setPageSize(ps);
		int totalCount = bd.getTotalCount();//获取总记录数
		//再设置总记录数
		page.setTotalCount(totalCount);
		//这样就可以算出总页码 getTotalPage();
		page.setPageNo(pn);
		
		//3、查询数据并封装
		List<Book> list = bd.getPageList(page.getIndex(), page.getPageSize());
		page.setPageData(list);
		return page;
	}
	
	
	@Override
	public Page<Book> getPageByPriece(String pageNo, String pageSize, String maxPrice, String minPrice) {
		double min = 0.0;
		double max = Double.MAX_VALUE;
		try {
			min = Double.parseDouble(minPrice);
			max = Double.parseDouble(maxPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//1、将用户传入的数据先封装部分
		Page<Book> page = new Page<Book>();
		//将用户传入的数据转型并封装
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		//2、将页码以及页面大小设置进入page对象
		//按照价格区间获取总记录数
		int count = bd.getTotalCountByPrice(min, max);
		page.setTotalCount(count);
		page.setPageSize(ps);
		
		//这是最后设置
		page.setPageNo(pn);
		
		//3、查询相应数据
		List<Book> list = bd.getPageByPrice(page.getIndex(), page.getPageSize(), min, max);
		
		//4、封装进page对象
		page.setPageData(list);
		
		return page;
	}
}
