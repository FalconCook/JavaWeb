package com.cracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cracker.bean.Book;
import com.cracker.bean.Cart;
import com.cracker.service.BookService;
import com.cracker.service.impl.BookServiceImpl;
import com.cracker.utils.WebUtils;

@WebServlet("/client/CartServlet")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bs = new BookServiceImpl();

	/**
	 * 将图书添加到购物车
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2bean2(request, new Book());
		HttpSession session = request.getSession();
		// 获取购物车
		Cart cart = WebUtils.getCart(request);
		Book one = bs.getOne(book);
		cart.addBook2Cart(one);
		session.setAttribute("title", one.getTitle());
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	/**
	 * 删除某个购物项
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取购物车
		Cart cart = WebUtils.getCart(request);
		// 删除购物项，根据用户传来的图书id
		cart.deleteItem(request.getParameter("id"));
		// 返回cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);

	}

	/**
	 * 修改数量
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取购物车
		Cart cart = WebUtils.getCart(request);
		// 修改完成
		cart.updateCount(request.getParameter("id"), request.getParameter("count"));
		// 返回cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void clear(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取购物车
		Cart cart = WebUtils.getCart(request);
		cart.clear();
		// 返回cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}
}
