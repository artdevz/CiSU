package com.CaniNUS.dto.universities;

import java.util.UUID;

import com.CaniNUS.models.UniversityModel;

public record UniversityResponseDTO(UUID universityId, String universityName) {
    public UniversityResponseDTO(UniversityModel university) {
        this(university.getId(), university.getUniversityName());
    }
}
