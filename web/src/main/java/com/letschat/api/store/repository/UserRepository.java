package com.letschat.api.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.letschat.api.store.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
