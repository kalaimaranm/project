package com.bassure.microservice.restbasic.entity;

import java.time.LocalDate;

public class User {

    private Integer id;
    private String name;
    private LocalDate dob;

    public User(Integer id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", dob=" + dob + '}';
    }

}
