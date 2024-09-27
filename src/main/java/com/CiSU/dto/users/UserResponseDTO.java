package com.CiSU.dto.users;

import java.util.UUID;

import com.CiSU.enums.ERole;
import com.CiSU.models.UserModel;

public record UserResponseDTO(UUID id, String userName, String userEmail, String userPassword, ERole userRole, float score) {
    public UserResponseDTO(UserModel user) {
        this(user.getId(), user.getUserName(), user.getUserEmail(), user.getPassword(), user.getUserRole(), user.getUserScore());
    }
}