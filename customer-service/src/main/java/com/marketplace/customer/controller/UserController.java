package com.marketplace.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.customer.domains.UserEntity;
import com.marketplace.customer.repository.UserRepository;
import com.marketplace.customer.services.SendEmailProxyService;
/**
 * 
 * @author sepehr safari
 *
 */
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private SendEmailProxyService emailProxy;
	
	@GetMapping("/customers")
	public List<UserEntity> retrieveRegisteredUsers() {
		List<UserEntity> users = userRepo.findAll();
		return users;
	}

	@GetMapping("/customers/{firstname}/{lastname}")
	public  ResponseEntity<UserEntity> retrieveUser(@PathVariable("firstname") String firstname, 
			                               		    @PathVariable("lastname") String lastname) {
		UserEntity user = userRepo.find(lastname, firstname);
		return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
	}
	
	@PostMapping("/customer/register")
	public ResponseEntity<?> registerCustomer(@RequestBody UserEntity user) {
		if (userRepo.save(user) != null) {
			emailProxy.sendRegistrationConfirmation(user.getLastName());
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
/*	@PostMapping("/customer/add/{firstname}/{lastname}/{strip}")
	public  ResponseEntity<?> updateUserStripPaymentId(@PathVariable("firstname") String firstname, 
													   @PathVariable("lastname") String lastname,
													   @PathVariable("stripe") String stripe) {
		UserEntity user = userRepo.findByLastNameAndFirstName(lastname, firstname);
		if (user != null) {
			user.setToken(stripe);
			userRepo.save(user);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
*/
}
