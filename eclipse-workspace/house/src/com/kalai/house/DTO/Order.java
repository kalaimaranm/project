package com.kalai.house.DTO;

public class Order {

	String item;
	int quantity;

	public Order() {
		System.out.println(">> Order Object is called...");
	}

	public Order(String item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [item=" + item + ", quantity=" + quantity + "]";
	}
}
