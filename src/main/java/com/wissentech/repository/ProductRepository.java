package com.wissentech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissentech.model.Soapdetails;

public interface ProductRepository extends JpaRepository<Soapdetails, Integer> {

}