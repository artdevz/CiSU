package com.CiSU.dto.courses;

import java.util.UUID;

import com.CiSU.models.CourseModel;

public record CourseFilterDTO(UUID id, String uniName, String uniCity, String name) {
    public CourseFilterDTO(CourseModel course) {
        this(course.getId(), course.getCourseUniversityName(), course.getCourseUniversityCity(), course.getCourseName());
    }
}