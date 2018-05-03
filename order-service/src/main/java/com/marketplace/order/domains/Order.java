package com.marketplace.order.domains;


//import com.marketplace.customer.domains.Address;

//@Entity
public class Order {

	//@Id
	private Long id;
	private ShoppingCart cart;
	private PaymentMethod payment;
//	private Address shippingAddress;
	private OrderStatus status;
	
	public Order(Long id, ShoppingCart cart, PaymentMethod payment) {
		super();
		this.id = id;
		this.cart = cart;
		this.payment = payment;
//		this.shippingAddress = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public PaymentMethod getPayment() {
		return payment;
	}

	public void setPayment(PaymentMethod payment) {
		this.payment = payment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

/*	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}*/
}
