package com.bassure.khatabook.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
