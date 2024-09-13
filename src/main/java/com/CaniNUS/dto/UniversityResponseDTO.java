package com.CaniNUS.dto;

import com.CaniNUS.models.UniversityModel;

public record UniversityResponseDTO(String universityName) {
    public UniversityResponseDTO(UniversityModel university) {
        this(university.getUniversityName());
    }
}
