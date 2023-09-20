package com.bassure.khatabook.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
//@Getter
@Setter
//@ToString
public class Customer {

    private int id;
    private String password;
    private String name;
    private String phone;
//    private String gender;
    private String aadhaar;
    private double debtBalance = 0.0;
    private double walletBalance = 0.0;
    private boolean status = true;
    private Address address;

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public double getDebtBalance() {
        return debtBalance;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }
    
    
    
    

    
    
    
    
    @Override
    public String toString() {
        status = status;
        return "\nID : " + id + "\nName : " + name + "\nPhone : " + phone + "\nAadhaar : " + aadhaar + "\nDebt Balance : " + debtBalance + "\nWallet Balance : " + walletBalance + address;
    }

//    public int getId() {
//
//        return id;
//    }
}
