package com.transactionalBank.demo.controllers;

import com.transactionalBank.demo.dto.UserDTO;
import com.transactionalBank.demo.entities.User;
import com.transactionalBank.demo.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO users){
        UserDTO response = service.createUser(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }
}
