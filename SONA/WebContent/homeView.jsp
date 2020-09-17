<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

fieldset{
background-color:#E6E6FA;
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
hr{
    width:400px;
      margin: 0px;
}
</style>

<link rel='stylesheet' href='stylecss.css' type='text/css' />
<meta charset="UTF-8">
<title>Order</title>

<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</head>
<body class="body">
<div id="page-container">
<div id="content-wrap">

	<form method="POST" action="AddOrderServlet">
		<div class="container">
			<center>


				<fieldset>
					<h1>Order</h1>
				
				<p>Placing an Order.</p>
				<hr>


				<div class=input>
					<label for="product">Select product </label><br>
						<input type="text"name="product" placeholder="product" required /><br> 
				
					<br> <label for="quantity">Enter Quantity</label><br> 
					<input type="number" name="quantity"  required /><br><br>
					 <br> <label for="subTotal">SubTotal</label><br>
					  <input type="number" name="subTotal"   required /><br>
					<br> <label for="discount">Discount</label>
					<p>0.00</p>
					<label for="total">Total</label><br>
					 <input type="number" name="total"  required /> <br>
				</div>
                   <br><br>
                   
                   

				<div class="l_buttons">
					<input type="submit" id="outer" value="Confirm order"
						class="add-button" /> <input type="reset" id="outer"
						value="Refresh" class="reset-button" />

				</div>
				<br>
	</form>
	<div class="l_buttons">
	<form method="POST" action="ListOrderServlet">
		<input type="submit" id="outer" value="Show Order history"
			class="list-button" />

	</form>
	<div class="l_buttons">
	</center>
	</div>

</fieldset>
</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	
</div>

</body>

</html>



