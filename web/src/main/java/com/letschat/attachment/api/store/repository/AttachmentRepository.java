package com.letschat.attachment.api.store.repository;

import com.letschat.attachment.api.store.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
