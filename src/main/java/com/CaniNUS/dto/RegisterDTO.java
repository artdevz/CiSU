package com.CaniNUS.dto;

import com.CaniNUS.enums.ERole;

public record RegisterDTO(String name, String email, String password, ERole role) {}
