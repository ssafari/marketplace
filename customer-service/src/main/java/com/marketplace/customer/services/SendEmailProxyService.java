package com.marketplace.customer.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="mail-service")
public interface SendEmailProxyService {

	@GetMapping("/mail-service/send/{name}")
	public ResponseEntity<?> sendRegistrationConfirmation(@PathVariable("name") String name);
}
