package com.bassure.khatabook.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LineItem {

    private int orderID;
    private int productID;
    private int quantity;
    private String productName;
    private double price;

}
