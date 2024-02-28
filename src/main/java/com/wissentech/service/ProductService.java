package com.wissentech.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.wissentech.model.Soapdetails;
import com.wissentech.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public Page<Soapdetails> list(Pageable page) {
		Page<Soapdetails> l1=repo.findAll(page);
		return l1;
	}

	public void save(Soapdetails soap) {
		repo.save(soap);
	}
	public Soapdetails get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
