package com.wissentech.orderfieghclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wissentech.model.Order;
@FeignClient(name = "Order-Details")
public interface Orderfeighclient {
	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	List<Order> getOrders();
	
	@RequestMapping(method = RequestMethod.POST, value = "/orders/postorders")
    void postOrders(Order order);
}