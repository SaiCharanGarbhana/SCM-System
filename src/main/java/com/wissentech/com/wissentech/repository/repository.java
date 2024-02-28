package com.wissentech.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wissentech.order.Order;

@Repository
public interface repository extends MongoRepository<Order, String> {

}
