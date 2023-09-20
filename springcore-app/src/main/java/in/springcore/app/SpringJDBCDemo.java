package in.springcore.app;

import in.springcore.bean.User;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJDBCDemo {

    JdbcTemplate jdbcTemplate;

    public SpringJDBCDemo(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {

//        SpringJDBCDemo jdbcDemo = new SpringJDBCDemo(null);
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        
        
        UsersRepository usersComponent = context.getBean(UsersRepository.class);
        
        List<User> users = usersComponent.getUser();
        
        for (User user : users) {
             System.out.println(user);
        }

    }
}
