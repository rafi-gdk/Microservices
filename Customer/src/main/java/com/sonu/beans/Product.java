package com.sonu.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	private Integer id; 
	private String name;
	private Double fare;
	public Product() {}
	public Product(Integer id, String name,Double fare) {
		super();
		this.id = id;
		this.name = name;
		this.fare = fare;

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}

}
