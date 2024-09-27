package com.CiSU.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CiSU.models.VacancyModel;

@Repository
public interface VacancyRepository extends JpaRepository<VacancyModel, UUID> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM vacancies WHERE (:courseId is NULL OR course_id = :courseId) ORDER BY vacancy_score DESC LIMIT :numOfPlaces")
    List<VacancyModel> findAllVacancies(UUID courseId, int numOfPlaces);

}
