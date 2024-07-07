package com.letschat.core.controller;

import com.letschat.api.service.UserOperationService;
import com.letschat.api.store.entity.CreateUserRequest;
import com.letschat.api.store.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserOperationService userOperationService;

    @Autowired
    public UserController(UserOperationService userOperationService) {
        this.userOperationService = userOperationService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userOperationService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest userRequest) {
        Optional<User> createdUser = userOperationService.createUser(userRequest);
        return createdUser.isPresent()
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : ResponseEntity.badRequest().build();
    }
}
