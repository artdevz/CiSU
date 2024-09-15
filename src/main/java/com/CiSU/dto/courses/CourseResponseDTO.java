package com.CiSU.dto.courses;

import java.util.UUID;

import com.CiSU.models.CourseModel;

public record CourseResponseDTO(UUID courseUniversity, String courseUniversityName, String courseUniversityCity, String courseName, int courseNumOfPlaces, int courseDuration) {
    public CourseResponseDTO(CourseModel course) {
        this(course.getCourseUniversity(), course.getCourseUniversityName(), course.getCourseUniversityCity(), course.getCourseName(), course.getCourseNumOfPlaces(), course.getCourseDuration());
    }
}
