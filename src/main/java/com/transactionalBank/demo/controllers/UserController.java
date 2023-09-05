package com.transactionalBank.demo.controllers;

import com.transactionalBank.demo.dto.UserDTO;
import com.transactionalBank.demo.entities.User;
import com.transactionalBank.demo.servicies.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){
        UserDTO response = service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> user = service.findAll();
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByid(@PathVariable Long id) throws Exception {
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }
}
