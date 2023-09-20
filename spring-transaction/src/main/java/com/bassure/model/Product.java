package com.bassure.model;


import java.time.LocalDate;

public record Product(int id,
        String name,
        LocalDate expirationDate) {

}
