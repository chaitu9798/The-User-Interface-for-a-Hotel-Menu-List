<%@page import="java.util.Iterator"%>
<%@page import="org.truyum.app.Items"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
 <head>
 <link rel="stylesheet" href="menulist-customer.css"></link>
  <title>Menu-item-list-customer</title>
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
	<a href="GetCustomerItems" target="blank"><font color="white"><u>Menu</u></font><a>
	</div>
	<div id="Cart">
	<a href="GetCartItems" target="blank"><font color="white"><u>Cart</u></font><a>
	</div>
</div>
	<div id="section">
  <table id="sectionlist">
  <h2>Menu Items</h2>
  
  <tr>
	<td><strong>Name</strong></td>
	<td><pre>		</pre></td>
	<td><center><strong>Free Delivery</strong></center></td>
	<td></td>
	<td><center><strong>Price</strong><center></td>
	<td></td>
	<td><center><strong>Category</strong></center></td>
	<td></td>
	<td><center><strong>Action</strong></center></td>
  </tr>
  <%String status = null;
  	status = (String) session.getAttribute("status");
  	if(status=="true") {
  		out.print("<tr>");
  		out.print("<center><font color='green'>Item added to cart Successfully</font></center>");
  		out.print("</tr>");
  		
  	}
  %>
  
   	<%
   	List<Items> l1 = (List<Items>) session.getAttribute("customerItems");
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
   			out.print("</td>");
   			out.print("<td>");
   			out.print(i2.getCategory());
   			out.print("</td>");
   			out.print("<td>");
   			out.print("<a href='SaveCartItems?name="+i2.getName()+"'>AddToCart</a>");
   			out.print("</td>");
   			out.print("</tr>");
   		}
   			j++;
   		
   		}
   	}
   
   	%>
  <!-- 
  <tr>
	<td>Sandwitch</td>
	<td></td>
	<td><center>Yes</center></td>
	<td></td>
	<td><center>Rs.99.00</center></td>
	<td></td>
	<td><center>Main Course</center></td>
	<td></td>
	<td><a href="menu-item-list-customer-notification.html" target="blank"><u>Add to Cart</u></a></td>
  </tr>
  <tr>
	<td>Berger</td>
	<td></td>
	<td><center>No</center></td>
	<td></td>
	<td><center>Rs.129.00</center></td>
	<td></td>
	<td><center>Main Course</center></td>
	<td></td>
	<td><a href="menu-item-list-customer-notification.html" target="blank"><u>Add to Cart</u></a></td>
  </tr>
  <tr>
	<td>Pizza</td>
	<td></td>
	<td><center>No</center></td>
	<td></td>
	<td><center>Rs.149.00</center></td>
	<td></td>
	<td><center>Rs.149.00</center></td>
	<td></td>
	<td><a href="menu-item-list-customer-notification.html" target="blank"><u>Add to Cart</u></a></td>
  </tr>
   -->
  </table>
  </div>
  
  <div id="footer">
  <h5>copyright &copy; 2020</h5>
  </div>
 </body>
</html>
