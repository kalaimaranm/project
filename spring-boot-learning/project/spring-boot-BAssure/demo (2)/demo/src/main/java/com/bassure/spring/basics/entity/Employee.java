package com.bassure.spring.basics.entity;

import com.bassure.spring.basics.annotation.Age;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Employee {

    @NotBlank(message = "firstName should not be blank")
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Age(minimumAge = 18, maximumAge = 48)
    private Integer age;
    private String password;

    public Employee(String firstName, String lastName, String email, String password, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + '}';
    }

}
