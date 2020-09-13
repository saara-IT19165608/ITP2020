<!-- 
	ITP 2020 Textile Management System
	
	@author V. Yahdhursheika - IT19186948

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link href="styles.css" rel="stylesheet" type="text/css">
</head>

<body>

	<h1>Add Product</h1>
	<hr>
	
	<form action="ProductAdd_AdminServlet" method="post">
	
	<div class="container">
	
		<label>Enter Product Name</label><br><br>
		<input type="text" name="name" placeholder="Enter Product Name" required><br><br><br>
		
		<label>Enter Product Quantity</label><br><br>
		<input type="number" name="qty" placeholder="Enter Quantity" required><br><br><br>
		
		<label>Enter Price</label><br><br>
		<input type="number" name="price" placeholder="Enter Price" required><br><br><br>
	
		<label>Enter Size</label><br><br>
		<input type="text" name="size" placeholder="Enter Size" required><br><br><br>
		
		<label>Enter Re-Order Level</label><br><br>
		<input type=number name="reOrderLevel" placeholder="Enter Re-Order Level" required><br><br><br>
		
		<label>Choose Category</label><br><br>
		<select class="select" name="category" required>
				<option value="Mens' wear">Men's wear</option>
				<option value="Women's wear">Women's wear</option>
				<option value="Boys' wear">Boys' wear</option>
				<option value="Girls' wear">Girls' wear</option>
				<option value="Babies' wear">Babies' wear</option>
				<option value="Essentials">Essentials</option>
		</select><br><br>
		
		<!-- image to added into form -->
		
		<input type="submit" value="Add Employee" id="submit">
		<input type="reset" value="Reset Form" id="reset">

	</div>
	
	</form>

</body>
</html>