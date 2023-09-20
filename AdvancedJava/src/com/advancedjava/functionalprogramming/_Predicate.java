package com.advancedjava.functionalprogramming;

import java.util.function.Predicate;
import static com.advancedjava.functionalprogramming._Predicate.Employee;
import java.util.Scanner;

public class _Predicate {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

//        Employee employee1 = new Employee(39874, "Revi", false);
//        System.out.println(findingCustomerStatus.test(employee1));
        System.out.println("Enter phone number");
        String phone = scan.next();                      
        System.out.println("Entered phone number is " + (lengthValidationPredicate
                .and(startValidationPredicate)
                .or(endValidationPredicate)
                .test(phone) ? "valid number" : "Invalid number"));

    }

    static Predicate<Employee> findingCustomerStatus = (employee) -> employee.getStatus();

    // phone number validation using predicate by seperating one by one
    static Predicate<String> lengthValidationPredicate = (phone) -> phone.length() == 10;  // must
    static Predicate<String> startValidationPredicate = (phone) -> phone.startsWith("99"); // must
    static Predicate<String> endValidationPredicate = (phone) -> phone.endsWith("78");     // optional
//    static Predicate<String> 
   
    static class Employee {

        private int id;
        private String name;
        private boolean status;

        public Employee(int id, String name, boolean status) {
            this.id = id;
            this.name = name;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

}
