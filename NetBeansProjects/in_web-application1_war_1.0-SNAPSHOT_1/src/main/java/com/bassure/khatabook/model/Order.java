package com.bassure.khatabook.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private int customerID;
    private double total;
    private String dateTime;
    private LineItem[] lineItem;
}
