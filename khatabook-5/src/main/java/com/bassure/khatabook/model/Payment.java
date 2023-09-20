package com.bassure.khatabook.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    private int orderID;
    private int customerID;
    private double amount;
    private String dateTime;
    private String discription;

}
