package com.Fresh.Hotels;

import org.springframework.stereotype.Component;

@Component
public class DeliveryPartner implements Delivery{
	
	public String deliveryStatus() {
		return "Your order will be delivered at 11.00PM by delivery partner Swiggy\nBill Amount is Rs. 592.00";
	}
}
