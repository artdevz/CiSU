package com.CiSU.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.CiSU.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserDetails findByUserEmail(String userEmail);

    @Query(nativeQuery = true, value = "SELECT score FROM users WHERE id = :id")
    float findScoreById(UUID id);

}
