<%@page import="org.truyum.app.Items"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
 <head>
  <title>Menu-item-list-admin</title>
  <link rel="stylesheet" href="menulist-admin.css"></link>
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
	<a href="GetAdminItems" ><font color="white"><u>Menu</u></font><a>
	</div>
  </div>
  <div id="section">
  <table id="sectionlist">
  <h2>Menu Items</h2>
  <tr>
	<td><strong>Name</strong></td>
	<td><pre>		</pre></td>
	<td><center><strong>Price</strong><center></td>
	<td><center><strong>Active</strong></center></td>
	<td><center><strong>Date of Launch</strong></center></td>
	<td><center><strong>Category</strong></center></td>
	<td><center><strong>Free Delivery</strong></center></td>
	<td><center><strong>Action</strong></center></td>
  </tr>
  
   	<%
   	List<Items> l1 = (List<Items>) session.getAttribute("adminItems");
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
   			out.print(i2.getPrice());
   			out.print("</td>");
   			out.print("<td>");
   			out.print(i2.getActive());
   			out.print("</td>");
   			out.print("<td>");
   			out.print(i2.getDateOfLaunch());
   			out.print("</td>");
   			out.print("<td>");
   			out.print(i2.getCategory());
   			out.print("</td>");
   			out.print("<td>");
   			out.print("<center>"+i2.getFreeDelivery()+"</center>");
   			out.print("</td>");
   			out.print("<td>");
   			out.print("<a href='DeleteAdminItems?name="+i2.getName()+"'>Remove</a>");
   			out.print("</td>");
   			out.print("</tr>");
   		}
   			j++;
   		
   		} 
   	}else {
			out.print("No Items to Show..!");
		}
   
   	%>
   	<!--  
	<td>Sandwitch</td>
	<td></td>
	<td><center>Rs.99.00</center></td>
	<td><center>Yes</center></td>
	<td><center>15/03/2017</center></td>
	<td><center>Main Course</center></td>
	<td><center>Yes</center></td>
	<td><a href="edit-menu-list.html"target="blank"><u>Edit</u></a></td>
  </tr>
  <tr>
	<td>Berger</td>
	<td></td>
	<td><center>Rs.129.00</center></td>
	<td><center>Yes</center></td>
	<td><center>23/12/2017</center></td>
	<td><center>Main Course</center></td>
	<td><center>No</center></td>
	<td><a href="edit-menu-list.html"target="blank"><u>Edit</u></a></td>
	
  </tr>
  <tr>
	<td>Piza</td>
	<td></td>
	<td><center>Rs.149.00</center></td>
	<td><center>Yes</center></td>
	<td><center>21/08/2017</center></td>
	<td><center>Main Course</center></td>
	<td><center>No</center></td>
	<td><a href="edit-menu-list.html"target="blank"><u>Edit</u></a></td>
	
  </tr>
  <tr>
	<td>Frech Fries</td>
	<td></td>
	<td><center>Rs.57.00</center></td>
	<td><center>Yes</center></td>
	<td><center>02/07/2017</center></td>
	<td><center>staters</center></td>
	<td><center>Yes</center></td>
	<td><a href="edit-menu-list.html"target="blank"><u>Edit</u></a></td>
	
  </tr>
  <tr>
	<td>Chocolate Browsie</td>
	<td></td>
	<td><center>Rs.32.00</center></td>
	<td><center>Yes</center></td>
	<td><center>02/01/2022</center></td>

	<td><center>Dessert</center></td>
	<td><center>Yes</center></td>
	<td><a href="edit-menu-list.html"target="blank"><u>Edit</u></a></td>
  </tr>
  -->
  </table>
  </div>
  <div id="footer">
  <h5>copyright &copy; 2020</h5>
  </div>

 </body>
</html>
