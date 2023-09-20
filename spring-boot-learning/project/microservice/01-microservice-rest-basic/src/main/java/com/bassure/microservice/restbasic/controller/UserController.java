package com.bassure.microservice.restbasic.controller;

import com.bassure.microservice.restbasic.repository.UserDaoImpl;
import com.bassure.microservice.restbasic.entity.User;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

    @Autowired
    UserDaoImpl userDaoImpl;

    private MessageSource messageSource;

    public UserController(MessageSource messageSource) {

        this.messageSource = messageSource;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {

        return userDaoImpl.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {

        return userDaoImpl.getUsers();
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {

        user = userDaoImpl.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable Integer id) {

        userDaoImpl.deleteUser(id);
        return "user account deleted successfully";
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {

        return userDaoImpl.updateUser(user);
    }

    @GetMapping("/internationalization")
    public String goodmorningInternationalization() {
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message", null, "defaultMessage", locale);
    }

}
