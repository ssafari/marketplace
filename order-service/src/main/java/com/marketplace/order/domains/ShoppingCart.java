package com.marketplace.order.domains;

import java.util.List;


//import com.marketplace.store.StoreItem;

//@Entity
public class ShoppingCart {

	//@Id
	private Long id;
	private List<Item> listItems;
	
	public ShoppingCart(Long id, List<Item> listItems) {
		super();
		this.id = id;
		this.listItems = listItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Item> getListItems() {
		return listItems;
	}

	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}
	
	
	
}
