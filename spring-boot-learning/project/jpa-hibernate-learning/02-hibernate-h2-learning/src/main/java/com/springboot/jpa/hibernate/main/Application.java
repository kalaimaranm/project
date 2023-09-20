package com.springboot.jpa.hibernate.main;

import com.springboot.jpa.hibernate.entity.Course;
import com.springboot.jpa.hibernate.dao.CourseRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    CourseRepositoryImpl courseRepositoryImpl;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        Course course = courseRepositoryImpl.addCourse(new Course("dummy"));
//        Course result = courseRepositoryImpl.findCourseById(course.getId());
//        log.info("command-line-runner : ->", result);
//        System.out.println(result);
//
//    }
    @Bean
    public Application applicationn() {

//        Course course = courseRepositoryImpl.addCourse(new Course("dummy"));
//        Course result = courseRepositoryImpl.findCourseById(course.getId());
//        log.info("command-line-runner -> {}", result);
//        System.out.println(result);
//        Course fileData = courseRepositoryImpl.findCourseById(10l);
//        log.info("command-line-runner getting data from sql file -> {}", fileData);
//
        return new Application();
    }

    @Override
    public void run(String... args) throws Exception {

        Course course = courseRepositoryImpl.addCourse(new Course("dummy"));
        Course result = courseRepositoryImpl.findCourseById(course.getId());
        log.info("command-line-runner -> {}", result);
        System.out.println(result);
        Course fileData = courseRepositoryImpl.findCourseById(10l);
        log.info("command-line-runner getting data from sql file -> {}", fileData);
    }

}
