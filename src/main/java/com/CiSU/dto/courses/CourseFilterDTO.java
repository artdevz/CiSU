package com.CiSU.dto.courses;

import com.CiSU.models.CourseModel;

public record CourseFilterDTO(String uniName, String uniCity, String name) {
    public CourseFilterDTO(CourseModel course) {
        this(course.getCourseUniversityName(), course.getCourseUniversityCity(), course.getCourseName());
    }
}