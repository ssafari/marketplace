package com.marketplace.payment.stripe;

public class StripeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3989181671540462110L;

	public StripeException(Throwable e) {
        super(e);
    }
}
