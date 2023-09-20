package com.advancedjava.JDBC;

import java.util.Scanner;
import java.util.Stack;

public class JDBC {

    static Customer[] cus = new Customer[0];
    static int id = 10393;

    public static void main(String[] args) {
        cus[0] = new Customer("kalai", "8610825343", id, "Thukkari Kodavasal Thiruvarur");
        cus[0] = new Customer("maram", "9023232323", cus[cus.length - 1].getId() + 1, "Thukkari Kodavasal Thiruvarur");
        cus[0] = new Customer("Hari", "9087962506", cus[cus.length - 1].getId() + 1, "Thukkari Kodavasal Thiruvarur");
        cus[0] = new Customer("Natraj", "0987654321", cus[cus.length - 1].getId() + 1, "Thukkari Kodavasal Thiruvarur");
        cus[0] = new Customer("Jobin", "1234567890", cus[cus.length - 1].getId() + 1, "Thukkari Kodavasal Thiruvarur");

        Customer.update(cus);
    }

}

class Customer {

    private String name;
    private int id;
    private String phNo;
    private String address;

    public Customer(String name, String phNo, int id, String address) {
        this.name = name;
        this.phNo = phNo;
        this.address = address;
    }

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

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    static void update(Customer[] cus) {
//        Arrays.stream(cus).filter(fil-> {
//        if(fil.getPhNo().equals("0987654321"){
//          })
//            }

    }

    public static void main2(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            Stack<Character> st = new Stack<Character>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                    st.push(input.charAt(i));
                } else if (input.charAt(i) == ')' || input.charAt(i) == ']' || input.charAt(i) == '}') {
                    if(!(st.isEmpty())){
                    if ((input.charAt(i) == ')' && st.peek() == '(') || (input.charAt(i) == '}' && st.peek() == '{') || (input.charAt(i) == ']' && st.peek() == '[')) {
                        st.pop();
                    }
                    }
                    // else{
                    //     System.out.println(false);
                    //     break;
                    // }
                }
            } //}}}} - > this is also empty only so its true
            if (st.isEmpty()) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
            //  st.clear();
        }

    }
//     public static void main(String[] args) {
//        String name = "harish";
//        System.out.println("""
//                           Hai,
//                           My name is "%s"
//                           """.formatted(name));
//    }
//    

}
