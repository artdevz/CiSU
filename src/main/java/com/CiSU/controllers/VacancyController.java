package com.CiSU.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CiSU.dto.vancicies.VacancyDTO;
import com.CiSU.models.VacancyModel;
import com.CiSU.repositories.VacancyRepository;

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