package com.letschat.user.api.store.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequest {

    @NotBlank
    private Long id;

    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;
}
