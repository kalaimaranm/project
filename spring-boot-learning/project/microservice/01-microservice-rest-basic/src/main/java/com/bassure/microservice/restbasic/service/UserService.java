package com.bassure.microservice.restbasic.service;

import com.bassure.microservice.restbasic.repository.UserDaoImpl;
import com.bassure.microservice.restbasic.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    public User addUser(User user) {

        return userDaoImpl.addUser(user);

    }

    public User getUserById(Integer id) {

        return userDaoImpl.getUserById(id);

    }

    public List<User> getUsers() {

        return userDaoImpl.getUsers();

    }

    public boolean deleteUserById(Integer id) {

        return userDaoImpl.deleteUser(id);

    }

    public User updateUser(User user) {

        return userDaoImpl.updateUser(user);

    }
}
