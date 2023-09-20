package com.advancedjava.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class _Stream {

    public static void main(String... args) {
        List<Employee> listOfEmployee = new ArrayList<Employee>();

        listOfEmployee.add(new Employee(1000, "Jobin", Gender.MALE, 15000));
        listOfEmployee.add(new Employee(1000, "Jothika", Gender.FEMALE, 15000));
        listOfEmployee.add(new Employee(1000, "kalaimaran", Gender.MALE, 15000));
        listOfEmployee.add(new Employee(1000, "Abdul", Gender.MALE, 15000));
        listOfEmployee.add(new Employee(1000, "Naveen", Gender.MALE, 15000));
        listOfEmployee.add(new Employee(1000, "XXXX", Gender.OTHERS, 15000));
        listOfEmployee.add(new Employee(1000, "Dhivya", Gender.FEMALE, 15000));

        List maleEmployee = listOfEmployee.stream()
                .filter(employee -> employee.getGender().equals(Gender.MALE))
                .limit(3)
                .collect(Collectors.toList());
        maleEmployee.forEach(System.out::println);

        
       List<DAOEmployee> daoEmployee = listOfEmployee.stream().map(employee -> 
                                   new DAOEmployee(employee.getId()
                                                        ,employee.getName()
                                                        ,employee.getGender()
                                                        ,employee.getSalary()))
                               .collect(Collectors.toList());
        
        System.out.println("\nconvert employee into DAOEmployee using map \n");
        daoEmployee.forEach(System.out::println);
         // storing into stream 
//                Stream stream = listOfEmployee.stream();
        // storing array into stream
//      Stream stream2= Arrays.stream({10,20,30,40});
    Map<String,List<Employee>> employe = new HashMap<>();
//    employe.get
    }

    public static class Employee {

        private int id;
        private String name;
        private Gender gender;
        private double salary;

        public Employee(int id, String name, Gender gender, double salary) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + '}';
        }
    }

    public enum Gender {
        MALE,
        FEMALE,
        OTHERS;

    }

    public static class DAOEmployee {

        private int id;
        private String name;
        private Gender gender;
        private double salary;

        public DAOEmployee(int id, String name, Gender gender, double salary) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "DAOEmployee{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + '}';
        }
    }
}
