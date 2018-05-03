package com.marketplace.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsDataController {
	
	@Autowired
	private PropConfigurations configuration;

	@GetMapping("/limits")
	public LimitsData retrieveLimitsFromConfigurations() {
		LimitsData limitConfiguration = new LimitsData(configuration.getMaximum(), 
				configuration.getMinimum());
		return limitConfiguration;
	}
}
