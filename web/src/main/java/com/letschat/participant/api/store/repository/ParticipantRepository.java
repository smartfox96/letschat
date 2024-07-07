package com.letschat.participant.api.store.repository;

import com.letschat.participant.api.store.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
