package com.wissentech.controller;

import java.sql.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissentech.model.Order;

import com.wissentech.model.Soapdetails;
import com.wissentech.orderfieghclient.Orderfeighclient;
//import com.wissentech.order.feighclient.orderfeighclient;
import com.wissentech.service.ProductService;

import ch.qos.logback.classic.Logger;
//import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	private Orderfeighclient orderfeighclient;

	@GetMapping("/getproduct")
	public Page<Soapdetails> list(Pageable page) {
		Page<Soapdetails> pgbl = service.list(page);
		return pgbl;

	}
	
	@PostMapping("/orders")
	public void saveModel( @RequestBody Order order) {
	orderfeighclient.postOrders(order);
	}
	
	@GetMapping("/orders")
	public List<Order> getOrders() {
		return orderfeighclient.getOrders();
	}

	@GetMapping("/productbyid/{id}")
	public ResponseEntity<Soapdetails> get(@PathVariable Integer id) {
		try {
			Soapdetails soap = service.get(id);
			return new ResponseEntity<Soapdetails>(soap, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Soapdetails>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/postproduct")
	public void add(@RequestBody Soapdetails soap) {
		service.save(soap);
	}

	@PutMapping("/putproduct/{id}")
	public ResponseEntity<?> update(@RequestBody Soapdetails soap, @PathVariable Integer id) {
		try {
			Soapdetails soap1 = service.get(id);
			service.save(soap1);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} 
	}

	@DeleteMapping("/deleteproduct/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
