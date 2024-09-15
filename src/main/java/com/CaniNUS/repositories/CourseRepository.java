package com.CaniNUS.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CaniNUS.models.CourseModel;

public interface CourseRepository extends JpaRepository<CourseModel, UUID> {

    @Query(nativeQuery = true, value = "SELECT name FROM courses WHERE university_id = :id AND name = :name")
    String findByIdAndName(UUID id, String name);

    @Query(nativeQuery = true, value = "SELECT * FROM courses WHERE " +
                                        "(:uniName IS NULL OR university_name LIKE %:uniName%) AND " +
                                        "(:uniCity IS NULL OR university_city LIKE %:uniCity%) AND " +
                                        "(:name IS NULL OR name LIKE %:name%)"
                                        )
    List<CourseModel> findAllCourses(String uniName, String uniCity, String name);

}