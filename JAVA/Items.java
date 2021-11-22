package org.truyum.app;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Items
 *
 */
@Entity
public class Items implements Serializable {
	@Id
	@Column(name="name")
	private String name;
	@Column(name="price")
	private String price;
	@Column(name="active")
	private String active;
	@Column(name="dateOfLaunch")
	private String dateOfLaunch;
	@Column(name="category")
	private String category;
	@Column(name="freeDelivery")
	private String freeDelivery;
	private static final long serialVersionUID = 1L;

	public Items() {
		super();
	}   
	
	
	@Override
	public String toString() {
		return "Items [name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch=" + dateOfLaunch
				+ ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}   
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}   
	public String getDateOfLaunch() {
		return this.dateOfLaunch;
	}

	public void setDateOfLaunch(String dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}   
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}   
	public String getFreeDelivery() {
		return this.freeDelivery;
	}

	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
   
}
