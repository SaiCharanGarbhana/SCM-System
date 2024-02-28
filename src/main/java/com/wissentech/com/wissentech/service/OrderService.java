package com.wissentech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.wissentech.order.Order;
import com.wissentech.repository.repository;

@Service
public class OrderService {

	@Autowired
	private repository repo;
	
	public List<Order> listAll() {
		return repo.findAll();
	}

	public Page<Order> getAll(Pageable page) {
		Page<Order> list = repo.findAll(page);
		return list;
	}

	public Order persistEmployee(Order order) {
		return repo.save(order);

	}

	public Optional<Order> getbyId(String id) {
		return repo.findById(id);
	}

	public void deleteEmployee(String id) {
		repo.deleteById(id);
	}

}
