package in.springcore.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new User(rs.getInt(1), rs.getString(2), rs.getLong(3));

    }

}
