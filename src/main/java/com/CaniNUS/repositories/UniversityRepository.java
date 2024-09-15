package com.CaniNUS.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CaniNUS.models.UniversityModel;

public interface UniversityRepository extends JpaRepository<UniversityModel, UUID> {

    UniversityModel findByUniversityName(String name);

    @Query(nativeQuery = true, value = "SELECT name FROM universities WHERE id = :id")
    String findNameById(UUID id);

    @Query(nativeQuery = true, value = "SELECT city FROM universities WHERE id = :id")
    String findCityById(UUID id);
    
}
