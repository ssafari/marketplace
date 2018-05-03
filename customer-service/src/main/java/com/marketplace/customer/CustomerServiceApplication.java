package com.marketplace.customer;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.marketplace.customer.domains.Address;
import com.marketplace.customer.domains.UserEntity;
import com.marketplace.customer.repository.UserRepository;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.marketplace.customer")
public class CustomerServiceApplication implements CommandLineRunner {

	@Autowired
    private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("747 Golf View Road", "225", "San Jose",
                "California", "USA", "94117"));
        addresses.add(new Address("1111 Boynton ave", null, "Sunnyvale",
                "California", "USA", "94617"));

        UserEntity user = new UserEntity("Jean", "Smith", "jsmith@winsome.com", "jeansmith", addresses);

        userRepository.save(user);
	}
}
