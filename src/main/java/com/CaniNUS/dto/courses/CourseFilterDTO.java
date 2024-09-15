package com.CaniNUS.dto.courses;

import com.CaniNUS.models.CourseModel;

public record CourseFilterDTO(String uniName, String uniCity, String name) {
    public CourseFilterDTO(CourseModel course) {
        this(course.getCourseUniversityName(), course.getCourseUniversityCity(), course.getCourseName());
    }
}