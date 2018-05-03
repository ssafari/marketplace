package com.marketplace.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/mail-service")
public class MailController {

	private static final Logger LOG = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send/{name}")
	public ResponseEntity<?> sendRegistrationConfirmation(@PathVariable("name") String name) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		
		message.setText("Hello "+name+" your registration is completed");
		if (emailService != null) {
			emailService.sendGenericEmailMessage(message);
		} else {
			LOG.error("Mailservice is NULL !");
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
