<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.itp.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itp.service.OrderServiceImpl"%>
<%@page import="com.itp.service.IOrderService"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<title>Order management system</title>


</head>
<body>


	<br>
	<h4 style="text-align: center">My Orders</h4>
	

	<div align="center">
		<table border="1" cellpadding="12">


			<tr style="background-color: #9370DB">
				<th>Order ID</th>
				<th>Product</th>
				<th>Quantity</th>
				<th>Sub Total</th>
				<th>Discount</th>
				<th>Total</th>
				<th>Purchase Date</th>
				<th>Status</th>


			</tr>
			<%
            	IOrderService iOrderService = new OrderServiceImpl();
                        	ArrayList<Order> arrayList = iOrderService.getOrders();
                        	
                        	for(Order order : arrayList){
            %>
			<tr>
				<td><%=order.getOrderID() %></td>
				<td><%=order.getProduct() %></td>
				<td><%=order.getQuantity() %></td>
				<td><%=order.getSubTotal() %></td>
				<td><%=order.getDiscount() %></td>
				<td><%=order.getTotal() %></td>
				<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
				<td><%= df.format(new java.util.Date()) %></td>
				<td><%=order.getStatus() %></td>
				

				<td>
					<form method="POST" action="GetOrderServlet">
						<input type="hidden" name="orderID"
							value="<%=order.getOrderID()%>" /> <input type="submit"
							value="Edit/Cancel Order" class="select-button" />
					</form>
				</td>
			</tr>

			

			<%	
			   }
            %>


<form action="ReportServlet">
<input type="submit" style="margin-left:900px;margin-bottom:10px;" value="Order Report" >
</form>

		</table>
	</div>


	<br>
	<a href="homeView.jsp"
		style="margin: 0 auto; display: block; text-align: center">Continue
		Shopping</a>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

	
</html>