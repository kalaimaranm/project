package com.springboot.jpa.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    public Course(){}

    public Course(String name) {

        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + '}';
    }

}
