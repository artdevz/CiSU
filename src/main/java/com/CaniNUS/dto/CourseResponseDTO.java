package com.CaniNUS.dto;

import java.util.UUID;

import com.CaniNUS.models.CourseModel;

public record CourseResponseDTO(UUID courseUniversity, String courseName, int courseNumOfPlaces, int courseDuration) {
    public CourseResponseDTO(CourseModel course) {
        this(course.getCourseUniversity(), course.getCourseName(), course.getCourseNumOfPlaces(), course.getCourseDuration());
    }
}
