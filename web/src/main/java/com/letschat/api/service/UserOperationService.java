package com.letschat.api.service;

import com.letschat.api.store.entity.CreateUserRequest;
import com.letschat.api.store.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserOperationService {

    Optional<User> createUser(CreateUserRequest createUserRequest);

    List<User> getAllUsers();


}
