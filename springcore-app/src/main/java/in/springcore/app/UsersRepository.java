package in.springcore.app;

import in.springcore.bean.User;
import in.springcore.bean.UserRowMapper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {

    private JdbcTemplate jdbcTemplate;

    public UsersRepository(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public List<User> getUser() {
        return jdbcTemplate.query("SELECT * FROM user", new UserRowMapper());
    }

}
