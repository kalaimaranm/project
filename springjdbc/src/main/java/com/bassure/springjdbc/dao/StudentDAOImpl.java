package com.bassure.springjdbc.dao;

import com.bassure.springjdbc.extractor.StudentResultSetExtractor;
import com.bassure.springjdbc.record.Student;
import com.bassure.springjdbc.record.Students;
import com.bassure.springjdbc.rowmapper.StudentRowMapper;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
//@Scope(value = "prototype")
public class StudentDAOImpl implements StudentDAO {

    private static JdbcTemplate jdbcTemplate;

    public StudentDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean insertStudent(Student student) {

        return jdbcTemplate.update("INSERT INTO student (age, name) VALUES(?,?)",
                student.age(),
                student.name()) > 0;
    }

//    list of object array
    public boolean insertStudent(List<Student> students) {

        List<Object[]> studentDataList = new ArrayList();

        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(students.toArray());
        for (Student student : students) {
            studentDataList.add(new Object[]{student.age(),
                student.name()});

        }
        int[] result = jdbcTemplate.batchUpdate("INSERT INTO student (age, name) VALUES (?,?)", studentDataList);

        for (int i : result) {
            System.out.println(i);
        }
        return result.length == students.size();

    }

    public List<Student> findAllStudent() {
//    starts from here and go RowMapper and come back to here loop ......
        return jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());

    }

//    IMPORTANT
    public boolean clearAll() {

        try {
            jdbcTemplate.execute("TRUNCATE student");
        } catch (DataAccessException dae) {
            return false;
        }
        return true;
    }
// column and field name should be same else use Alias

    public Students getStudentById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM student where id = ?",
                new BeanPropertyRowMapper<Students>(Students.class),
                id);

//        return null;
    }

    public boolean deleteStudentById(int id) {

        return false;
    }

    public boolean batchUpdate(List<Student> students) {
        List<Object[]> batch = new ArrayList();

        batch.add(new Object[]{"thangam", 2010});
        batch.add(new Object[]{"ajith", 2012});
        batch.add(new Object[]{"praveen", 2011});
//        for (Student student: students) {
//            batch.add
//                    
//        }
//        jdbcTemplate.update("", batch);

        return jdbcTemplate.batchUpdate("update student set age = age - 2, name = ? where id = ?", new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int index) throws SQLException {

                ps.setString(1, (String) batch.get(index)[0]);
                ps.setInt(2, (int) batch.get(index)[1]);

                System.out.println("inside setValues() >>> index : " + index);

            }

            @Override
            public int getBatchSize() {

                System.out.println("inside the getBatchSize() >>>>>");
                return batch.size();
            }
        }
        ).length == batch.size();
//        return jdbcTemplate.batchUpdate("update student set age = age + 1, name = ? where id = ?", batch).length != 0;

    }

    public List<Student> getStudentByName(String name) {

        return jdbcTemplate.query("SELECT * FROM student where name = ?",
                new StudentResultSetExtractor(),
                name);
    }

    public boolean deleteStudentAgeOrName() {

        return false;
    }

    public static void checking() {
        System.out.println("object of Jdbc: " + jdbcTemplate.toString());
    }
}
