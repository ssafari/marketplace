package com.marketplace.order.domains;

public class PaymentMethod {
	
	private Long customerId;
	private String method;
	private String token;
	
	public PaymentMethod(Long customerId, String method, String token) {
		super();
		this.customerId = customerId;
		this.method = method;
		this.token = token;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
