package com.bassure.springjdbc.main;

import com.bassure.springjdbc.dao.StudentDAOImpl;
import com.bassure.springjdbc.extractor.DummyDAOImpl;
import com.bassure.springjdbc.record.Student;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        StudentDAOImpl studentDAOImpl = context.getBean(StudentDAOImpl.class);
//        System.out.println(studentDAOImpl.insertStudent(new Student("Vengat", 22)));
//       Insert-Batch-Student
//        List<Student> students = new ArrayList();
//        students.add(new Student("Thangam", 23));
//        students.add(new Student("Praveev", 24));
//        students.add(new Student("Ajith", 27));
//        students.add(new Student("Bharathi", 25));
//        System.out.println(studentDAOImpl.insertStudent(students));
//        Get-All-User
        System.out.println("Getting all user by RowMapper>>>>>>>>>>");
//        studentDAOImpl
//                .findAllStudent()
//                .forEach(student -> System.out.println(student));

//     Get-User-By-Id
//        System.out.println(studentDAOImpl.getStudentById(2005));
//        System.out.println(studentDAOImpl.batchUpdate(null));
//     
//        System.out.println("Getting student by ResultSetExtractor>>>>>>>>>>");
//        studentDAOImpl.getStudentByName("Vengat")
//                .forEach(student -> System.out.println(student));
//        StudentDAOImpl st = context.getBean("studentDAOImpl", StudentDAOImpl.class);
//        st.checking();
//        DummyDAOImpl.checking();
        studentDAOImpl.batchUpdate(null);

    }

}
