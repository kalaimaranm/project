package com.springboot.jpa.hibernate.dao;

import com.springboot.jpa.hibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryImpl {

    @Autowired
    EntityManager em;

    public Course findCourseById(Long id) {

        return em.find(Course.class, id);
    }

    @Transactional
    public Course addCourse(Course course) {

        if (Objects.nonNull(course.getId())) {
            
            return em.merge(course);
        }

        em.persist(course);

        return course;

    }

    public void deleteCourseById(Long id) {

        Course course = findCourseById(id);
        em.remove(course);

    }

//    public 
}
