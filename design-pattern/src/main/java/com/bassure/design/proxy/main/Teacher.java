package com.bassure.design.proxy.main;

import java.util.Date;

public class Teacher {

    public static void main(String... args) {

        DailySession student = new StudentProxy(1001, "Arunachalam",
                new Attendance(new Date(), true));
        
        student.attendSession();
    }

}
