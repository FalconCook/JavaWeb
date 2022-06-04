package com.cracker.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cracker.bean.Constant;
import com.cracker.bean.Order;
import com.cracker.service.OrderService;
import com.cracker.service.impl.OrderServiceImpl;

@WebServlet("/manager/OrderManagerServlet")
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	OrderService orderService=new OrderServiceImpl();
       
	/**
	 * 列出所有订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取所有订单
		List<Order> list = orderService.getAllOrder();
		//保存到域中
		request.setAttribute("orders", list);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}
	
	/**
	 * 发货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deliver(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从页面获取订单号
		String orderid = request.getParameter("orderid");
		//修改订单状态
		orderService.updateStatus(orderid, Constant.DELIVERING+"");
		//回到页面
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}
	
	

}
