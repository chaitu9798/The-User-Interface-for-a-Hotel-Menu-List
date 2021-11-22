package org.truyum.app;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cart
 *
 */
@Entity
public class Cart implements Serializable {
	@Id
	@Column(name="name")
	private String name;
	@Column(name="freeDelivery")
	private String freeDelivery;
	@Column(name="price")
	private Double price;
	private static final long serialVersionUID = 1L;

	public Cart() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getFreeDelivery() {
		return this.freeDelivery;
	}

	public void setFreeDelivery(String freeDelivery) {
		this.freeDelivery = freeDelivery;
	}   
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
  }
