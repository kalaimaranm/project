package com.bassure.design.proxy.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@AllArgsConstructor
@NoArgsConstructor

public class StudentProxy extends Student {

    public StudentProxy(int id, String name, Attendance attendance) {
        super(id, name, attendance);
    }

    @Override
    public void attendSession() {

        System.out.println(super.getAttendence().isPresent());

        if (!super.getAttendence().isPresent()) {

            throw new RuntimeException("Sorry Student is absent...\n Not allowed to attend session...!");
        }

        super.attendSession();
    }

}
