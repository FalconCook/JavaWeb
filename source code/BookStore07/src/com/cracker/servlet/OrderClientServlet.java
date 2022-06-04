package com.cracker.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cracker.bean.Cart;
import com.cracker.bean.Constant;
import com.cracker.bean.Order;
import com.cracker.bean.User;
import com.cracker.service.OrderService;
import com.cracker.service.impl.OrderServiceImpl;
import com.cracker.utils.WebUtils;

@WebServlet("/client/OrderClientServlet")
public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    OrderService orderService = new OrderServiceImpl();  
	
    public OrderClientServlet() {
        super();
    }

	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//1、获取已经登录的用户
		User loginUser = WebUtils.getLoginUser(request);
		//2、登陆则结算
		if(loginUser!=null) {
			//代表用户已经登陆
			Cart cart = WebUtils.getCart(request);
			//结算，返回订单号
			String orderid = orderService.checkout(cart, loginUser);
			session.setAttribute("orderId", orderid);
			response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
		}else {
			//3、否则直接返回登陆页面提示用户登陆
			request.setAttribute("msg", "请先登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * 列出当前用户所有订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = WebUtils.getLoginUser(request);
		List<Order> list = null;
		try {
			list = orderService.getMyOrders(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//保存所有订单
		request.setAttribute("orders", list);
		
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	/**
	 * 确认收货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void received(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String orderid = request.getParameter("orderid");
		//确认收货
		orderService.updateStatus(orderid, Constant.DELIVERED+"");
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}
}
