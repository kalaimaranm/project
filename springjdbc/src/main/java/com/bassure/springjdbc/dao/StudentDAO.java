package com.bassure.springjdbc.dao;

import com.bassure.springjdbc.record.Student;
import java.util.List;

public interface StudentDAO {

    public boolean insertStudent(List<Student> students);

    public boolean insertStudent(Student student);

    public List<Student> findAllStudent();

    public boolean clearAll();

    public List<Student> getStudentByName(String name);
}
