package com.cracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cracker.bean.Book;
import com.cracker.bean.Page;
import com.cracker.service.BookService;
import com.cracker.service.impl.BookServiceImpl;

@WebServlet("/client/BookClientServlet")
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookServiceImpl();
      
	/**
	 * 给用户展示图书的分页数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用户点击图书管理显示部分数据，页码应该是用户传进的
		String pn = request.getParameter("pn");
		Page<Book> page = bookService.getPage(pn, "4");
		page.setUrl("client/BookClientServlet?method=page");
		//将第一页的数据放到页码显示
		request.setAttribute("page", page);
		//交给页面
		request.getRequestDispatcher("/pages/book/booklist.jsp")
				.forward(request, response);
	}

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取价格区间
		String max = request.getParameter("max");
		String min = request.getParameter("min");
		String pn = request.getParameter("pn");
		System.out.print("按价格查询方法：min->"+min+"--max:"+max);

		//查询价格区间的所有图书
		Page<Book> page = bookService.getPageByPriece(pn, "4", max, min);
		page.setUrl("client/BookClientServlet?method=pageByPrice&max="+max+"&min="+min);
		
		//返回页面显示
		request.setAttribute("page", page);
		request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}
}
