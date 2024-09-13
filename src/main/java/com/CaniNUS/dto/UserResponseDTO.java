package com.CaniNUS.dto;

import java.util.UUID;

import com.CaniNUS.enums.ERole;
import com.CaniNUS.models.UserModel;

public record UserResponseDTO(UUID id, String userName, String userEmail, String userPassword, ERole userRole) {
    public UserResponseDTO(UserModel user) {
        this(user.getId(), user.getUserName(), user.getUserEmail(), user.getPassword(), user.getUserRole());
    }
}