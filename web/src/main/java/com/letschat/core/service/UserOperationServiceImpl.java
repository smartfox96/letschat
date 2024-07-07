package com.letschat.core.service;

import com.letschat.api.service.UserOperationService;
import com.letschat.api.store.entity.CreateUserRequest;
import com.letschat.api.store.entity.User;
import com.letschat.api.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private String createPasswordHash(String password) {
        return password;
    }
}
