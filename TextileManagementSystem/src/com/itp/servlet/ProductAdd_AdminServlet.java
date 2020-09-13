/*
 * ITP 2020 Textile Management System
 * 
 * @author V. Yahdhursheika - IT19186948
 */

package com.itp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itp.model.Product;
import com.itp.service.*;

/**
 * Servlet implementation class ProductAdd_AdminServlet
 */
@WebServlet("/ProductAdd_AdminServlet")
public class ProductAdd_AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAdd_AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/adminViews/ProductAdd_Admin.jsp");
		rd.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		int qty = Integer.parseInt(request.getParameter("qty"));
		String size = request.getParameter("size");
		double price = Double.parseDouble(request.getParameter("price"));
		int reOrderLevel = Integer.parseInt(request.getParameter("reOrderLevel"));
		
		/*
		 * Creating an object from Product
		 * class and saving the details
		 */
		
		Product p1 = new Product();
		p1.setProductName(name);
		p1.setProductCategory(category);
		p1.setProductQty(qty);
		p1.setProductSize(size);
		p1.setProductPrice(price);
		p1.setProductReOrderLevel(reOrderLevel);
		System.out.println("hello");
		int status = 0;
		
		iProductService ip = new ProductServiceImpl();
		status = ip.addProduct(p1);
		
		if (status > 0) {
			System.out.println("Product"+p1.getProductName()+
					"Successfully added!");
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function{} {");
			out.println("swal('Success!', 'Product Added!', 'success');");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else {
			System.out.println("Error occurred, couldn't add product!");
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function{} {");
			out.println("swal('Error occurred', 'Added Product was not added', 'error');");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request, response);
		}
	}

}
