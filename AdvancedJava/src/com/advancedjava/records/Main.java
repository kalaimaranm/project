package com.advancedjava.records;

public class Main {

    public static void main(String... args) {

        StudentRecord studentRecord1 = new StudentRecord(100, "Naveen");
//        StudentRecord studentRecord2 = new StudentRecord(101, "    "); // throw Exception due to blank

        StudentClass studentClass1 = new StudentClass(200, "Arun");
        StudentClass studentClass2 = new StudentClass(201, "k");       // it is not validated
        
        System.out.println(studentRecord1);
//        System.out.println(studentRecord2);
        System.out.println(studentClass1);
        System.out.println(studentClass2);
        System.out.println(studentRecord1.timing());
//        studentRecord1.;

    }
}
