<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

.header {
  overflow: hidden;
  background-color:	#4B0082;
  padding: 20px 10px;
}
.header a {
  float: left;
  color: white;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}


.header a.logo {
  font-size: 30px;
  font-weight: bold;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
 .header-right {
    float: none;
  }


</style>
</head>
<body>

<div class="header">
  <a href="#default" class="logo">WORLD OF FASHION</a>
  </div>
  
<div class="topnav">
  <a class="active" href="#home">Home</a>
  <a href="#account">My Account</a>
  <a href="/ListOrderServlet">My Orders</a> 
  <a href="contactus">Contact us</a>
  <a href="\AboutUs.jsp">About us</a>
  <a href="#logout" style="float:right">Logout</a>
</div>


</body>
</html>
