package com.CaniNUS.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CaniNUS.models.CourseModel;

public interface CourseRepository extends JpaRepository<CourseModel, UUID> {

    Object findByCourseName(String name);
    
}
