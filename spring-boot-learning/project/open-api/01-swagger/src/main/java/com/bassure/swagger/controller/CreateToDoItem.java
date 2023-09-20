package com.bassure.swagger.controller;

import com.bassure.swagger.model.ToDoItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateToDoItem {

    @PostMapping(value = "/todos")
    public ResponseEntity<Object> createToDoItem(@RequestBody ToDoItem toDoItem) {
        return ResponseEntity.ok().body(toDoItem);
    }
}
