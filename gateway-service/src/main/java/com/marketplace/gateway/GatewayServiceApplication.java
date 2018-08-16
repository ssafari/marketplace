package com.marketplace.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

import zipkin2.server.internal.EnableZipkinServer;





@EnableZipkinServer
@EnableZuulServer
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return new AlwaysSampler();
	}
}
