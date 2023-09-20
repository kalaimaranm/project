/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bassure.transaction;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 *
 * @author bas200193
 */
@Component
public class Drivermanager extends DriverManagerDataSource
{ 
    private String url;
    private String username;
    private String password;

    public Drivermanager(String url, String username, String password) {
        this.url="jdbc:mysql://bassure.in/kalaimaran_db";
        this.username="Kalai";
        this.password="Kalai@4321";
    }
    
}
