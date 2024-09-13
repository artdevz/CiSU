package com.CaniNUS.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CaniNUS.models.UniversityModel;

public interface UniversityRepository extends JpaRepository<UniversityModel, UUID> {

    UniversityModel findByUniversityName(String name);
    
}
