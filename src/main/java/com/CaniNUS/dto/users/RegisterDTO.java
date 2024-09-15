package com.CaniNUS.dto.users;

import com.CaniNUS.enums.ERole;

public record RegisterDTO(String name, String email, String password, ERole role) {}
