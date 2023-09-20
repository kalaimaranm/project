package com.bassure.springjdbc.rowmapper;

import com.bassure.springjdbc.record.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet result, int rowNum) throws SQLException {

//        call-back function
//        int row = 0;
//        while (result.next()) {
//            ++row;
//        }
//        System.out.println("inside RowMapper result set size is: " + row);

        System.out.println("inside RowMapper()\n" + "row number is :" + rowNum);

        return new Student(result.getInt(1),
                result.getString(2),
                result.getInt(3));

    }

}
