package com.bassure.springjdbc.extractor;

import com.bassure.springjdbc.record.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<Student> students = new ArrayList();

        while (rs.next()) {
            students.add(new Student(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3)));

        }

        return students;

    }

}
