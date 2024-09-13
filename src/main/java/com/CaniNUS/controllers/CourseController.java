package com.CaniNUS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CaniNUS.dto.CourseDTO;
import com.CaniNUS.dto.CourseResponseDTO;
import com.CaniNUS.models.CourseModel;
import com.CaniNUS.repositories.CourseRepository;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@Controller
public class CourseController {
    
    @Autowired
    CourseRepository cr;

    // CRUD:

    @PostMapping("/course/create")
    public ResponseEntity createNewCourse(@RequestBody @Valid CourseDTO data) {

        if (this.cr.findByCourseName(data.name()) != null) return ResponseEntity.badRequest().build();

        CourseModel newCourse = new CourseModel(data.universityId(), data.name(), data.numOfPlaces(), data.duration());

        this.cr.save(newCourse);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/course/read")
    public ResponseEntity readAllCourses() {

        List<CourseResponseDTO> courseList = this.cr.findAll().stream().map(CourseResponseDTO::new).toList();

        return ResponseEntity.ok(courseList);

    }

}
