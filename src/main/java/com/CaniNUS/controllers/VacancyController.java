package com.CaniNUS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CaniNUS.dto.vancicies.VacancyDTO;
import com.CaniNUS.models.VacancyModel;
import com.CaniNUS.repositories.VacancyRepository;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@Controller
public class VacancyController {
    
    @Autowired
    VacancyRepository vr;

    // CRUD:

    @PostMapping("/vacancy/create")
    public ResponseEntity createNewVacancy(@RequestBody @Valid VacancyDTO data) {
        
        // VacancyModel vacancy = new VacancyModel(data.courseId(), data.candidatesId(), data.userId());
        VacancyModel vacancy = new VacancyModel(data.courseId(), data.userId());

        this.vr.save(vacancy);

        return ResponseEntity.ok().build();
    }

}