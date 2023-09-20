package com.bassure.springboot.main.service;

import com.bassure.springboot.main.dto.UserRequest;
import com.bassure.springboot.main.entity.User;
import com.bassure.springboot.main.exception.UserNotFoundException;
import com.bassure.springboot.main.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {

        User user = User.build(0l, userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobile(),
                userRequest.getGender(),
                userRequest.getAge(),
                userRequest.getNationality());
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {

        return userRepository.findAll();
    }

    public User findUserById(Long id) {

        Optional<User> result = userRepository.findById(id);

        if (result.isEmpty()) {

            throw new UserNotFoundException("user not found id - " + id);
        }
        return result.get();
    }

}
