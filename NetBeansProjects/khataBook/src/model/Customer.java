package model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    private int id;
    private String name;
    private String phone;
    private String aadhaar;
    private double debtBalance;
    private double walletBalance;
    private boolean status;
    private Address address;

    @Override
    public String toString() {
        status = status;
        return "\nID : " + id + "\nName : " + name + "\nPhone : " + phone + "\nAadhaar : " + aadhaar + "\nDebt Balance : " + debtBalance + "\nWallet Balance : " + walletBalance + address;
    }
}
