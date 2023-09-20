package com.bassure.khatabook.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private double profitPerUnit;
    private String weight;
    private int quantity;
    private String dateTime;
    private boolean status;
}
