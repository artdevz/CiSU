package com.CaniNUS.dto.vancicies;

import java.util.UUID;

import com.CaniNUS.models.VacancyModel;

public record VacancyResponseDTO(UUID courseId, UUID candidatesId, UUID userId) {
    public VacancyResponseDTO(VacancyModel vacancy) {
        this(vacancy.getVacancyCourse(), vacancy.getVacancyList(), vacancy.getVacancyUser());
    }
}
