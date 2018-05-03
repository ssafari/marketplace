package com.marketplace.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.order.domains.Item;
import com.marketplace.order.domains.ShoppingCart;
import com.marketplace.order.producer.Producer;


@RestController
public class OrderInputController {

	@Autowired
	private Producer producer;
	
	@PostMapping("/order/submit/cart")
	public ResponseEntity<String> submitOrder(@RequestBody ShoppingCart order_input) {
		for (Item item: order_input.getListItems())
			producer.send(item);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
