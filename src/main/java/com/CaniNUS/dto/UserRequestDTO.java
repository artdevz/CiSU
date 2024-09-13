package com.CaniNUS.dto;

import java.util.UUID;

import com.CaniNUS.enums.ERole;

// import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

    UUID id,

    // @NotBlank
    String name,

    // @NotBlank
    String email,

    // @NotBlank
    String password,

    // @NotBlank
    ERole role

) {}
