package com.letschat.user.api.service;

import com.letschat.user.api.store.entity.CreateUserRequest;
import com.letschat.user.api.store.entity.UpdateUserRequest;
import com.letschat.user.api.store.entity.User;

import java.util.Optional;

public interface UserOperationService {

    Optional<User> createUser(CreateUserRequest createUserRequest);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserById(Long id);

    Optional<User> updateUser(UpdateUserRequest updateUserRequest);

    boolean deleteUserById(Long id);
}
