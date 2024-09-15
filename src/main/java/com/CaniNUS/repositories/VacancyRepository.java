package com.CaniNUS.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CaniNUS.models.VacancyModel;

@Repository
public interface VacancyRepository extends JpaRepository<VacancyModel, UUID> {}
