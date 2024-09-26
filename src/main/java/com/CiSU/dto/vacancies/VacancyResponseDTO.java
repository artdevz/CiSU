package com.CiSU.dto.vacancies;

import java.util.UUID;

import com.CiSU.models.VacancyModel;

public record VacancyResponseDTO(UUID courseId, UUID userId, float vancancyScore) {
    public VacancyResponseDTO(VacancyModel vacancy) {
        this(vacancy.getVacancyCourse(), vacancy.getVacancyUser(), vacancy.getVacancyScore());
    }
}
