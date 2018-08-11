package com.example.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    ResponseEntity<String> test1() {
        return new ResponseEntity<String>("Test 1", HttpStatus.OK);
    }

    @GetMapping("/users/:id")
    ResponseEntity<String> test2(@PathVariable long id) {
        return new ResponseEntity<String>("Test 2", HttpStatus.OK);
    }

}
