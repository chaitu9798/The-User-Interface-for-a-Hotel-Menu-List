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

import org.springframework.web.servlet.ModelAndView;

@WebServlet("/saveItems")
public class saveItems extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Items i1 = new Items();
		HttpSession session = request.getSession();
		i1.setName(request.getParameter("name"));
		i1.setPrice(request.getParameter("price"));
		i1.setActive(request.getParameter("active"));
		i1.setCategory(request.getParameter("category"));
		i1.setDateOfLaunch(request.getParameter("dateOfLaunch"));
		i1.setFreeDelivery(request.getParameter("freeDelivery"));
		boolean status = JdbcCode.storeItems(i1);
		if(status) {
			RequestDispatcher req = request.getRequestDispatcher("edit-menu-list-status.html");
			req.include(request, response);
		} else {
			RequestDispatcher req = request.getRequestDispatcher("edit-menu-list.html");
			req.include(request, response);
		}
		
	}

}
