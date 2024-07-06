package com.letschat.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.letschat.store.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
