package com.bassure.design.proxy.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements DailySession {

    private int id;
    private String name;
    private Attendance attendence;

    @Override
    public void attendSession() {

        System.out.println("session is React-Native @ KB-2");
    }
}
