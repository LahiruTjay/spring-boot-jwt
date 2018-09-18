package com.example.jwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/users")
    ResponseEntity<String> test1() {
        return new ResponseEntity<String>("Test 1", HttpStatus.OK);
    }

    @GetMapping("/users/name")
    @PreAuthorize("hasAnyRole('ADMIN')")
    ResponseEntity<String> test2() {
        return new ResponseEntity<String>("Test 2 name", HttpStatus.OK);
    }
    
    @GetMapping("/admin/name")
    ResponseEntity<String> test3() {
        return new ResponseEntity<String>("Test 3 Name", HttpStatus.OK);
    }
    
    @GetMapping("/admin/age")
    ResponseEntity<String> test4() {
        return new ResponseEntity<String>("Test 4 Age", HttpStatus.OK);
    }

}
