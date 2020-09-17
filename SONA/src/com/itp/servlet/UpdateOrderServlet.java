package com.itp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.model.Order;

import com.itp.service.OrderServiceImpl;
import com.itp.service.IOrderService;


public class UpdateOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrderServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Order order = new Order();
		
		String orderID = request.getParameter("orderID");	
		order.setOrderID(orderID);
		order.setProduct(request.getParameter("product"));
		order.setQuantity(request.getParameter("quantity"));
		order.setSubTotal(request.getParameter("subTotal"));
		order.setDiscount("0.00");
		order.setTotal(request.getParameter("total"));
		order.setPurchaseDate(request.getParameter("purchaseDate"));
		order.setStatus("Processing");
		
		
		
		IOrderService iOrderService = new OrderServiceImpl();
		iOrderService.updateOrder(orderID, order);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListOrders.jsp");
		dispatcher.forward(request, response);
	}

}

