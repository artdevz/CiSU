package com.CiSU.dto.vacancies;

import java.util.UUID;

public record VacancyDTO(UUID courseId, UUID userId, float score) {}