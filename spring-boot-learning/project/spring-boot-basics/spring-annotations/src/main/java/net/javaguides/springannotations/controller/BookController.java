package net.javaguides.springannotations.controller;

import net.javaguides.springannotations.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/books")

public class BookController {

    @RequestMapping("/hello-world")
//    @ResponseBody
    public String helloWorld() {

        return "hello-world";
    }

    @RequestMapping(method = RequestMethod.GET,
             consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE})

    public Book getBook() {

        return new Book(1, "Core-Java", "Learn core and Latest feature");
    }

    @RequestMapping(value = "/books",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        return new ResponseEntity(book, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/books",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {

        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

}
