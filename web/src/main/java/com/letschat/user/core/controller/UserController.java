package com.letschat.user.core.controller;

import com.letschat.user.api.service.UserOperationService;
import com.letschat.user.api.store.entity.CreateUserRequest;
import com.letschat.user.api.store.entity.UpdateUserRequest;
import com.letschat.user.api.store.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserOperationService userOperationService;

    @Autowired
    public UserController(UserOperationService userOperationService) {
        this.userOperationService = userOperationService;
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userOperationService.getUserById(id);
        return user
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        Optional<User> user = userOperationService.getUserByEmail(email);
        return user
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody CreateUserRequest userRequest) {
        Optional<User> createdUser = userOperationService.createUser(userRequest);
        return createdUser.isPresent()
                ? new ResponseEntity<>(HttpStatus.CREATED)
                : ResponseEntity.badRequest().build();
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        Optional<User> updatedUser = userOperationService.updateUser(updateUserRequest);
        return updatedUser
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteUser(@RequestParam Long id) {
        boolean isDeleted = userOperationService.deleteUserById(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : ResponseEntity.badRequest().build();
    }
}
