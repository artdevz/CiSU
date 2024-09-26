package com.CiSU.dto.vacancies;

import java.util.UUID;

import com.CiSU.models.VacancyModel;

public record VacancyFilterDTO(UUID courseId, UUID userId, float vacancyScore) {
    public VacancyFilterDTO(VacancyModel vacancy) {
        this(vacancy.getVacancyCourse(), vacancy.getVacancyUser(), vacancy.getVacancyScore());
    }
}