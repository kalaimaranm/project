package com.bassure.microservice.restbasic.repository;

import com.bassure.microservice.restbasic.entity.User;
import com.bassure.microservice.restbasic.exception.UserNotFoundException;
import java.time.LocalDate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;

@Repository
public class UserDaoImpl {

    private static List<User> users = new ArrayList();
    private static Integer id = 0;

    static {

        users.add(new User(++id, "Ranga Karnam", LocalDate.now().minusYears(20)));
        users.add(new User(++id, "Chand", LocalDate.now().minusYears(20)));
        users.add(new User(++id, "Durga Soft", LocalDate.now().minusYears(20)));
    }

    public User getUserById(Integer id) {

        User data = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("user not found id - " + id));

        return data;
    }

    public List<User> getUsers() {

        return users;
    }

    public User addUser(User user) {

        User userData = new User(++id, user.getName(), user.getDob());

        users.add(userData);
        return userData;
    }

    public boolean deleteUser(Integer id) {

        return users.remove(users.stream().filter(user -> user.getId() == id)
                .findFirst()
                .get());
    }
 
    public User updateUser(User user) {
        System.out.println("userData : " + user);

        return (User) users.stream().filter(users -> users.getId() == users.getId())
                .map((userData) -> {
                    userData.setId(user.getId());
                    userData.setDob(user.getDob());
                    System.out.println("updated data : " + userData);
                    return userData;

                });
    }

}
