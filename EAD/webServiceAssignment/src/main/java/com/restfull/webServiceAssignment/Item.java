package com.restfull.webServiceAssignment;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * this class will store the item name and its quantity
 * @author Kunal
 */
@XmlRootElement
public class Item {
	private String name;
	private int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity + "]";
	}
	
}
