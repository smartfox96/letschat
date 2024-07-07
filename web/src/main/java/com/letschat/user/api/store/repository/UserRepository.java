package com.letschat.user.api.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.letschat.user.api.store.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
