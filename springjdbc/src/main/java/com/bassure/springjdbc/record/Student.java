package com.bassure.springjdbc.record;

public record Student(int id,
                 String name,
                     int age) {

    public Student(String name, int age) {
        this(0, name, age);
    }
}
