package com.cracker.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cracker.bean.Book;
import com.cracker.bean.Cart;
import com.cracker.bean.CartItem;
import com.cracker.service.BookService;
import com.cracker.service.impl.BookServiceImpl;
import com.cracker.utils.WebUtils;
import com.google.gson.Gson;

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
		
		// refer（请求地址）
		String refer = request.getHeader("referer");
		System.out.println(refer);
		response.sendRedirect(refer);
	}
	
	/**
	 * 使用ajax技术将图书加入购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2bean2(request, new Book());
		HttpSession session = request.getSession();
		// 获取购物车
		Cart cart = WebUtils.getCart(request);
		Book one = bs.getOne(book);
		cart.addBook2Cart(one);
		
		// 将图书加入成功以后，只需要返回部分数据（当前购物车图书总量，书名）
		// 不需要将书名放在session中，直接返回即可
		
		// 将数据回送给浏览器
		//当前购物车中所有书的数量
		int totalCount = cart.getTotalCount();
		//获取刚才添加图书的书名
		String title = one.getTitle();
		//为了js解析方便写JSON格式的数据
		//将这两个数据封装进对象里，将对象转为json字符串
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCount", totalCount);
		map.put("title", title);
		Gson gson = new Gson();
		// 将map转为json字符串
		String json = gson.toJson(map);
		// 将json字符串写给浏览器
		response.getWriter().write(json);
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
	
	protected void updateAjax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取购物车
		Cart cart = WebUtils.getCart(request);
		String bookid = request.getParameter("id");
		// 修改完成
		cart.updateCount(bookid, request.getParameter("count"));
		// 返回部分内容，修改的图书项的总金额，购物车的总金额，购物车的总数量
		// 找到修改的购物项
		CartItem item = cart.getItem(bookid);
		//获取购物项的总金额
		double totalPrice = item.getTotalPrice();
		//获取购物车的总数量
		int totalCount = cart.getTotalCount();
		//获取购物车的总金额
		double totalMoney = cart.getTotalMoney();
		Map<String, Object> map = new HashMap<>();
		map.put("totalPrice", totalPrice);
		map.put("totalCount", totalCount);
		map.put("totalMoney", totalMoney);
		//将数据转为json字符串返回
		Gson gson = new Gson();
		String json = gson.toJson(map);
		response.getWriter().write(json);
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
