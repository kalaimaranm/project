package com.Fresh.Hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
//@Component("burger")
public class BurgerKing implements Hotel {

	private String item;
	private int price;
	private String name;
	private int id;
//	@Autowired
//	private Delivery delivery;
//	@Autowired
//	private Message message;

//@Autowired    
	public BurgerKing() {
		System.out.println(">> Default constructor of BurgerKing class is called");
	}
//
//	public Delivery getDelivery() {
//		return delivery;
//	}
//
//	@Autowired
//	@Qualifier("deliveryPartner")
//	public void setDelivery(Delivery delivery) {
//		this.delivery = delivery;
//	}
//
//	public Message getMessage() {
//		System.out.println(">> setter method of message is called");
//		return message;
//	}
//	@PostConstruct
//	public static void init() {
//		System.out.println(">> Hey do my start up stuff.....");
//	}

//	@Autowired
//	public void setMessage(Message message) {
//		System.out.println(">> setter method of message is called");
//		this.message = message;
//	}

	// private
//	public BurgerKing() {
//		super();
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@Override
//	public String toString() {
//		return "BurgerKing{" + "item=" + item + ", price=" + price + '}';
//	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public BurgerKing(String item, int price) {
		this.item = item;
		this.price = price;
	}

	public String menu() {
		return " \n 1. Small Burger $99\n 2. Medium Burger $149\n 3. Larger Burger $179";
	}

	public boolean order() {
		return true;
	}
//
//	public String message() {
//		return message.sendMessage();
//	}
//
	@Override
	public String deliveryStatus() {
		// TODO Auto-generated method stub
		return "not implemented ";//delivery.deliveryStatus();
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		return null;
	}
}
