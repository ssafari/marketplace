package com.marketplace.store;



//@Entity
public class StoreItem {

	//@Id
	private Long id;
	
	private String item_name;
	private double price;
	
	
	public StoreItem(Long id, String item_name, double price) {
		super();
		this.id = id;
		this.item_name = item_name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
