package com.letschat.user.core.service;

import com.letschat.user.api.service.UserOperationService;
import com.letschat.user.api.store.entity.CreateUserRequest;
import com.letschat.user.api.store.entity.UpdateUserRequest;
import com.letschat.user.api.store.entity.User;
import com.letschat.user.api.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserOperationServiceImpl implements UserOperationService {

    private final UserRepository userRepository;

    @Autowired
    public UserOperationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> createUser(CreateUserRequest createUserRequest) {
        if (createUserRequest == null) {
            return Optional.empty();
        }

        String passwordHash = createPasswordHash(createUserRequest.getPassword());

        User user = User.builder()
                .username(createUserRequest.getName())
                .email(createUserRequest.getEmail())
                .passwordHash(passwordHash)
                .build();

        userRepository.save(user);

        return Optional.of(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(UpdateUserRequest updateUserRequest) {
        Optional<User> user = userRepository.findById(updateUserRequest.getId());
        if (user.isEmpty()) {
            return Optional.empty();
        }

        User updatedUser = user.get();
        updatedUser.setEmail(updateUserRequest.getEmail());
        updatedUser.setPasswordHash(updateUserRequest.getPassword());
        updatedUser.setUsername(updateUserRequest.getName());
        userRepository.save(updatedUser);

        return Optional.of(updatedUser);
    }

    @Override
    public boolean deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private String createPasswordHash(String password) {
        return password;
    }

    private String decryptPassword(String passwordHash) {
        return passwordHash;
    }
}
