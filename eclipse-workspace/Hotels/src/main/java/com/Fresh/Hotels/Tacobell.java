package com.Fresh.Hotels;

import org.springframework.beans.factory.annotation.Autowired;

//package com.Fresh.Hotels.Tacobell;

public class Tacobell implements Hotel{

    private String address;
    private long price;
    public Message message;
    private String name;
    private long number;
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}

	private DeliveryPartner deliveryPartner;
    public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public Tacobell() {
        super();
    }
//    public Tacobell(Message message,DeliveryPartner deliveryPartner) {
//    	this.message = message;
//    	this.deliveryPartner = deliveryPartner;
//    }
    public Tacobell(Message message) {
    	this.message = message;
    }
    public DeliveryPartner getDeliveryPartner() {
		return deliveryPartner;
	}
	public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
		this.deliveryPartner = deliveryPartner;
	}
	
//	public Tacobell(DeliveryPartner deliveryPartner,Message message) {
//    	this.message = message;
//    	this.deliveryPartner = deliveryPartner;
//    }
	
    public Tacobell(String address, long price) {
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    public String message() {
    	return message.sendMessage();
    }
    public String deliveryStatus() {
    	return deliveryPartner.deliveryStatus();
    }
    @Override
    public String toString() {
        return "Tacobell{" + "address=" + address + ", price=" + price + '}';
    }

    public String menu() {

        return "1. Burrito  $169\n2. Classic Burrito  $199\n3. Grilled Burrito  $199\n4. Burrito with Fries  $249\n5. Burrito with Coke  $249";
    }

    public boolean order() {

        return true;
    }
    

   

}
