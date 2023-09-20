package com.bassure.microservice.restbasic.controller;

import com.fasterxml.jackson.annotation.JsonFilter;



@JsonFilter("data-hiding-filter")
public class Filtering {

    private String name;
//    @JsonIgnore
    private String password;
    private String place;

    public Filtering(String name, String password, String place) {
        this.name = name;
        this.password = password;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Filtering{" + "name=" + name + ", password=" + password + ", place=" + place + '}';
    }

}
