package com.wissentech.model;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Soapdetails {
	private Integer id;
	private String name;
	private float price;
	private ZonedDateTime manu_date = ZonedDateTime.now();
	private ZonedDateTime exp_date = ZonedDateTime.now().plusDays(90);

	public Soapdetails() {
		super();
	}

	public Soapdetails(Integer id, String name, float price, ZonedDateTime manu_date, ZonedDateTime exp_date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.manu_date = manu_date;
		this.exp_date = exp_date;
	}

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ZonedDateTime getManu_date() {
		return manu_date;
	}

	public void setManu_date(ZonedDateTime manu_date) {
		this.manu_date = manu_date;
	}

	public ZonedDateTime getExp_date() {
		return exp_date;
	}

	public void setExp_date(ZonedDateTime exp_date) {
		this.exp_date = exp_date;
	}

}
