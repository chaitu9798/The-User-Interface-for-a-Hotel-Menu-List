package org.truyum.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.web.servlet.ModelAndView;

public class JpaCode {
	
	public static void getItemsToCustomer() {
				EntityManagerFactory factory = Persistence.createEntityManagerFactory("tru-yum");
				EntityManager manager = factory.createEntityManager();
				manager.getTransaction().begin();
				Items h = new Items();
				h.setActive("yes");
				h.setCategory("main");
				h.setDateOfLaunch("02/07/2019");
				h.setFreeDelivery("no");
				h.setName("pizza");
				h.setPrice(220.2);
				manager.persist(h);
				manager.getTransaction().commit();
				manager.close();
				ModelAndView view = new ModelAndView("last", "object", h);
				view.addObject(attributeName, attributeValue)
	}

}
