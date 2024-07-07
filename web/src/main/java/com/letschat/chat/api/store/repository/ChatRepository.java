package com.letschat.chat.api.store.repository;

import com.letschat.chat.api.store.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
