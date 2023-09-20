package com.advancedjava.enums;

public class Customer {
 
    int id;
    String name;
    Phone phone;

    public Customer(int id, String name, Phone phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    
  static Customer customer = new Customer(1010,"name", new Phone("countryCode","phoneno"));
}
