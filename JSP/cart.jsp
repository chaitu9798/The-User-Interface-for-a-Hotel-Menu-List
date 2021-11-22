<%@page import="java.util.Iterator"%>
<%@page import="org.truyum.app.Items"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
 <head>
 <link rel="stylesheet" href="menulist-customer.css"></link>
  <title>Cart</title>
 </head>
 <body>
  <div id="header">
	<div id="logoname">
	<font color="white">truYum</font>
	</div>
	<div id="logo">
	<img id="image"src="logo.PNG"></img>
	</div>
	<div id="space">
	</div>
	<div id="menulist">
	<a href="GetCustomerItems" target="blank"><font color="white"><u>Menu</u></font></a>
	</div>
	<!-- 
	<div id="Cart">
	<a href="GetCartItems" target="blank"><font color="white"><u>Cart</u></font></a>
	</div>
	 -->
</div>
	<form>
	<div id="section">
	<script src="cart-script.js"></script>
  <table id="sectionlist">
  <h2>Cart</h2>
  <p id="some"></p>
  
  <tr>
	<td><strong>Name</strong></td>
	<td><pre>		</pre></td>
	<td><strong>Free Delivery</strong></td>
	<td><center><strong>Price</strong></center></td>
	<td><center><strong>Action</strong></center></td>
	
  </tr>
  <%String deletestatus = null;
  	deletestatus = (String) session.getAttribute("deletestatus");
  	if(deletestatus=="true") {
  		out.print("<tr>");
  		out.print("<center><font color='red'>Item removed from cart Successfully</font></center>");
  		out.print("</tr>");
  		
  	}
  %>
  
  <%int sum = 0; %>
  <%
   	List<Items> l1 = (List<Items>) session.getAttribute("cartItems");
   	Iterator i1 = null;
   	if(l1!=null) {
   		i1 = l1.iterator();
   	}
   	if(i1!=null) {
   		int j=1;
   		while(j<5) {
   		
   			if(i1.hasNext()) {
   			out.print("<tr>");
   			Items i2 = new Items();
   			i2 = (Items) i1.next();
   			out.print("<td>");
   			out.print(i2.getName());
   			out.print("</td>");
   			out.print("<td>");
   			out.print("      ");
   			out.print("</td>");
   			out.print("<td>");
   			out.print(i2.getFreeDelivery());
   			out.print("</td>");
   			out.print("<td>");
   			out.print(i2.getPrice());
   			sum = sum + Integer.parseInt(i2.getPrice());
   			out.print("</td>");
   			out.print("<td>");
   			out.print("<a href='DeleteCartItems?name="+i2.getName()+"'>Delete</a>");
   			out.print("</td>");
   			out.print("</tr>");
   		}
   			j++;
   		
   		}
   	}
   
   	%>
   	<tr>
	<td></td>
	<td></td>
	<td><center><strong>Total</strong></center></td>
	<td><center><strong>Rs.<%=sum %></strong></center></td>
	<td></td>
  	</tr>
  <!-- 
  <tr>
	<td>Sandwitch</td>
	<td></td>
	<td><center>Yes</center></td>
	<td id="first"><center>Rs.99.00</center></td>
	<td></td>
	<td><a href="cart-notification.html" >Delete</a></td>
  </tr>
  <tr>
	<td>Burger</td>
	<td></td>
	<td><center>No</center></td>
	<td id="second"><center>Rs.129.00</center></td>
	<td></td>
	<td><a href="cart-notification.html" >Delete</a></td>
  </tr>
  <tr>
	<td>Pizza</td>
	<td ></td>
	<td ><center>NO</center></td>
	<td id="third"><center>Rs.149.00</center></td>
	<td></td>
	<td><a href="cart-notification.html" >Delete</a></td>
  </tr>
  </form>
  <tr>
	<td></td>
	<td></td>
	<td><center><strong>Total</strong></center></td>
	<td><center><strong>Rs.377.00</strong></center></td>
	<td></td>
	<td></td>
  </tr>
 -->
  </table>
  </div>
  
  <div id="footer">
  <h5>copyright &copy; 2020</h5>
  </div>
 </body>
</html>
