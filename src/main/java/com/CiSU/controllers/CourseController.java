package com.CiSU.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CiSU.dto.courses.CourseDTO;
import com.CiSU.dto.courses.CourseFilterDTO;
import com.CiSU.models.CourseModel;
import com.CiSU.repositories.CourseRepository;
import com.CiSU.repositories.UniversityRepository;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@Controller
public class CourseController {
    
    @Autowired
    CourseRepository cr;

    @Autowired
    UniversityRepository ur;

    // CRUD:

    @PostMapping("/course/create")
    public ResponseEntity createNewCourse(@RequestBody @Valid CourseDTO data) {

        if (this.cr.findByIdAndName(data.universityId(), data.name()) != null) return ResponseEntity.badRequest().build();

        CourseModel newCourse = new CourseModel(data.universityId(), data.name(), data.numOfPlaces(), data.duration());

        newCourse.setCourseUniversityName(ur.findNameById(data.universityId()));
        newCourse.setCourseUniversityCity(ur.findCityById(data.universityId()));
        
        this.cr.save(newCourse);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/course/read")
    public ResponseEntity readAllCourses(@RequestBody @Valid CourseFilterDTO data) {

        List<CourseFilterDTO> courseList = this.cr.findAllCourses(data.uniName(), data.uniCity(), data.name()).stream().map(CourseFilterDTO::new).toList();

        return ResponseEntity.ok(courseList);

    }

}
