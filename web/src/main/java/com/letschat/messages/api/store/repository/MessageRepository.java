package com.letschat.messages.api.store.repository;

import com.letschat.messages.api.store.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
