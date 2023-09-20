package com.bassure.springboot.demo.advice;

import org.springframework.http.HttpStatus;




public record ErrorMessage(HttpStatus httpStatus, String message) { }
