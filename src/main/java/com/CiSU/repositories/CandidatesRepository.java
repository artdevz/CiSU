package com.CiSU.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CiSU.models.CandidatesModel;

@Repository
public interface CandidatesRepository extends JpaRepository<CandidatesModel, UUID> {}
