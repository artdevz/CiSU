package com.CaniNUS.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.CaniNUS.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserDetails findByUserEmail(String userEmail);

}
