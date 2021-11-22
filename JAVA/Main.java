package org.truyum.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		//creating connection with the database
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tru-yum");
		
		//creating platform
		EntityManager manager = factory.createEntityManager();
		
		//DQL query
		manager.getTransaction().begin();
		Items h = new Items();
		h.setActive("yes");
		h.setCategory("main");
		h.setDateOfLaunch("02/07/2019");
		h.setFreeDelivery("no");
		h.setName("pizza");
		h.setPrice(220.2);
		
		//calling persist method to insert the row into the table
		manager.persist(h);
		
		manager.getTransaction().commit();
		
		//closing the platform
		manager.close();
		
	}

}
