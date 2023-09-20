package com.bassure.khatabook.model;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    //  not yet implemeted stock update price change for product tracking
    private int productID;
    private int quantity;
    private String dateTime;
    

}
