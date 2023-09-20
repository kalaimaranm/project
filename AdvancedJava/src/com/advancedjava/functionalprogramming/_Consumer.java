package com.advancedjava.functionalprogramming;

import static com.advancedjava.functionalprogramming._Consumer.Customer.greetingConsumer;
import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class _Consumer {

    public static void main(String[] args) {

        Customer customer = new Customer("Revi", "9876543210");
        System.out.println("Functional Consumer Greetings");
        greetingConsumer.accept(customer);
        System.out.println("\nnormal method Greeting");
        Customer.greetingConsumer(customer);

        System.out.println("\nBiConsumer Greeting with permitted(false)");
        greetingBiConsumer.accept(customer, false);
        System.out.println("\n\nnormal method Greeting with permitted(true)");
        greetingConsumer(customer, true);
    }

    // Consumer Functional interface take one argument and does n't return anything
    // Consumer
    static Consumer<Customer> greetingConsumer = customer
            -> System.out.println("Hello," + customer.getName()
                    + " Your registered phone number " + customer.getPhone());
    //BiConsumer Functional interface take two argument and does n't return anything 
    static BiConsumer<Customer, Boolean> greetingBiConsumer = (customer, permitted)
            -> System.out.println("Hello," + customer.getName()
                    + " Your registered phone number " + (permitted ? customer.getPhone() : "********"));

    static class Customer {

        private String name;
        private String phone;

        public Customer(String id, String phone) {
            this.name = id;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String id) {
            this.name = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public static void greetingConsumer(Customer customer) {
            System.out.println("Hello," + customer.getName()
                    + " Your registered phone number " + customer.getPhone());
        }

        public static void greetingConsumer(Customer customer, Boolean permission) {
            System.out.println("Hello," + customer.getName()
                    + " Your registered phone number " + (permission ? customer.getPhone() : "**********"));
        }
    }
}
