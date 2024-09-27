package com.CiSU.dto.users;

import com.CiSU.enums.ERole;

public record RegisterDTO(String name, String email, String password, ERole role) {}
