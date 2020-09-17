<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>World Of Fashion</title>
</head>
<body>
<center>
      <h1>Using POST Method to Read Form Data</h1>
      
      <ul>
         <li><p><b>First Name:</b>
            <%= request.getParameter("firstname")%>
         </p></li>
         <li><p><b>Email:</b>
            <%= request.getParameter("email")%>
         </p></li>
         <li><p><b>address:</b>
            <%= request.getParameter("address")%>
         </p></li>
         <li><p><b>city:</b>
            <%= request.getParameter("city")%>
         </p></li>
         <li><p><b>state:</b>
            <%= request.getParameter("state")%>
         </p></li>
         <li><p><b>zip:</b>
            <%= request.getParameter("zip")%>
         </p></li>
      </ul>
      
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

</body>
</html>