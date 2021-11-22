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

@WebServlet("/GetAdminItems")
public class GetAdminItems extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Items> l1 = JdbcCode.getItems();
		System.out.println(l1);
		session.setAttribute("adminItems", l1);
		RequestDispatcher req = request.getRequestDispatcher("menu-item-list-admin.jsp");
		req.include(request, response);
	}

	

}
