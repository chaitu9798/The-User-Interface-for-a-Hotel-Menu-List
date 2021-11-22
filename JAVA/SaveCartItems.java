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

@WebServlet("/SaveCartItems")
public class SaveCartItems extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Items i1 = new Items();
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		boolean status = JdbcCode.searchAndStoreItem(name);
		String state = null;
		if(status) {
			List<Items> l1 = JdbcCode.getItems();
			System.out.println(l1);
			session.setAttribute("customerItems", l1);
			state = "true";
			session.setAttribute("status", state);
			RequestDispatcher req = request.getRequestDispatcher("menu-item-list-customer.jsp");
			req.include(request, response);
		} else {
			RequestDispatcher req = request.getRequestDispatcher("menu-item-list-customer.jsp");
			req.include(request, response);
		}
	}

	

}
