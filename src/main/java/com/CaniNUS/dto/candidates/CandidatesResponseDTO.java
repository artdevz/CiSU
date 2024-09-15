package com.CaniNUS.dto.candidates;

import java.util.UUID;

import com.CaniNUS.models.CandidatesModel;

public record CandidatesResponseDTO(UUID courseId, UUID universityId) {
    public CandidatesResponseDTO(CandidatesModel candidates) {
        this(candidates.getCourseId(), candidates.getUniversityId());
    }
}
