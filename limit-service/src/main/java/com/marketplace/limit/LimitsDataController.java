package com.marketplace.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
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
