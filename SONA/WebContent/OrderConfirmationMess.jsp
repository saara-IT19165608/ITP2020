<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>

#his{
	width: 200px;

	 display: block;
  margin-right: auto;
  margin-left: auto;
  
	
}

.list-button{
background-color: #9370DB;
 padding: 15px 32px;
 color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>World Of Fashion</title>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</head>
<body>
<br><br>
	<center>
		<h1>Thank you for shopping with us !</h1>
	</center>
	
	<br><br>
<div id="his">
	<form method="POST" action="ListOrderServlet">
		<input type="submit" id="outer" value="Show Order History"
			class="list-button" />
		
	</form>
</div>
</body>
</html>