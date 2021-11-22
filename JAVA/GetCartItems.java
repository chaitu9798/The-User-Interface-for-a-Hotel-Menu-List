package org.truyum.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetCartItems")
public class GetCartItems extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Items> l1 = JdbcCode.getCartItems();
		System.out.println(l1);
		session.setAttribute("cartItems", l1);
		String deletestatus = "true";
		session.setAttribute("deletestatus", deletestatus);
		RequestDispatcher req = request.getRequestDispatcher("cart.jsp");
		req.include(request, response);
	}

	

}
