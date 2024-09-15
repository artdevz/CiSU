package com.CiSU.dto.universities;

import java.util.UUID;

import com.CiSU.models.UniversityModel;

public record UniversityResponseDTO(UUID universityId, String universityName) {
    public UniversityResponseDTO(UniversityModel university) {
        this(university.getId(), university.getUniversityName());
    }
}
