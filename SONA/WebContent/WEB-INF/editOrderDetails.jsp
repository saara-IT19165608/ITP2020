<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id = request.getParameter("orderID");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "userdb";
String userId = "root";
String password = "localhost";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit My Order </title>
<style>
.input {
	width: 280px;
}

.l_buttons {
	width: 400px;
	length: 200px
}

p {
	color: black;
}

label {
	color: black;
}
</style>

<link href="style.css" rel="stylesheet" type="text/css">
<style>
</style>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</head>
<body>
	<form action="" method="post" >
		<div class="container">
			<center>

				<fieldset>
					<legend>
						
					</legend>
					<p>Edit your shipment details</p>
					<hr >

					<div class=input>

						
						<label for="product"><b>Product</b></label> 
						<input type="text" name="product" required="required" >
							
						<label for="quantity"><b>Quantity</b></label>
						<input type="number" name="quantity"  required="required" > 
							
						<label for="subTotal"><b>Sub Total</b></label>
					    <input type="number" step="0.01" name="subTotal" required="required"  disabled> 
							
						<label for="discount"><b>Discount</b></label><br>
						<br> <input type="number" step="0.01" name="discount" required="required"  disabled><br>
						<br><br>
						
						<label for="total"><b>Total</b></label>
						<input type="number" name="total" step="0.01"  disabled> 
							
						<label for="purchaseDate"><b>Purchase Date</b></label> 
						<%= (new java.util.Date()).toLocaleString()%>
						
							
						<label for="status"><b>Status</b></label>
						<p>Processing</p>
						
						
			
			<form action="/OrderConfirmationMess.jsp">
  <input type="submit" value="Place Order" class="btn">
   </form>
   
    <div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
      <p><a href="#">Product 1</a> <span class="price">$15</span></p>
      <p><a href="#">Product 2</a> <span class="price">$5</span></p>
      <p><a href="#">Product 3</a> <span class="price">$8</span></p>
      <p><a href="#">Product 4</a> <span class="price">$2</span></p>
      <hr>
      <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
    </div>
  </div>	
					</div>
					

					<div class="l_buttons">
						<input type="submit" value="Save Changes" class="update-btn"><br>
						
					</div>

			</fieldset>	
	</form>
	</center>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</body>