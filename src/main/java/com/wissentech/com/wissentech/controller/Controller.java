package com.wissentech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.RestController;

import com.wissentech.order.Order;
import com.wissentech.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class Controller {

	@Autowired
	private OrderService OrderService;
	
	@GetMapping
	public List<Order> list() {
		return OrderService.listAll();
	}

	@GetMapping("/getorders")
	public Page<Order> getEmployees(Pageable page) {
		Page<Order> o1 = OrderService.getAll(page);
		return o1;

	}

	@PostMapping("/postorders")
	public Order saveModel(@Valid @RequestBody Order order) {
		return OrderService.persistEmployee(order);
	}
	@GetMapping("/getidbyorders/{id}")
	public Optional<Order> getEmployeeByID(@PathVariable String id) {
		return OrderService.getbyId(id);

	}

	@PutMapping("/putorders/{id}")
	public Order updateEmployeeByID(@PathVariable int id, @RequestBody Order order) {
		return OrderService.persistEmployee(order);

	}

	@DeleteMapping("/orders/{id}")
	public void deleteEmployeeByID(@PathVariable String id) {
		OrderService.deleteEmployee(id);

	}

	/*
	 * @GetMapping("/getEmpByName") public List<Employee>
	 * getEmpByName(@RequestParam("name") String name) { return
	 * service.getEmpByName(name); }
	 * 
	 * @GetMapping public List<Employee> getEmpByAge(@RequestParam("age") int age) {
	 * return service.getEmpbyAge(age); }
	 */

}
