package com.CiSU.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CiSU.dto.vacancies.VacancyDTO;
import com.CiSU.dto.vacancies.VacancyFilterDTO;
import com.CiSU.models.VacancyModel;
import com.CiSU.repositories.CourseRepository;
import com.CiSU.repositories.UserRepository;
import com.CiSU.repositories.VacancyRepository;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
@Controller
public class VacancyController {
    
    @Autowired
    VacancyRepository vr;

    @Autowired
    CourseRepository cr;

    @Autowired
    UserRepository ur;

    // CRUD:

    @PostMapping("/vacancy/create")
    public ResponseEntity createNewVacancy(@RequestBody @Valid VacancyDTO data) {        
        
        VacancyModel vacancy = new VacancyModel(data.courseId(), data.userId(), ur.findScoreById(data.userId()));

        this.vr.save(vacancy);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/vacancy/read")
    public ResponseEntity readAllVacacies(@RequestBody @Valid VacancyFilterDTO data) {
        
        List<VacancyFilterDTO> vacancyList = this.vr.findAllVacancies(data.courseId(), cr.findNumOfPlacesById(data.courseId())).stream().map(VacancyFilterDTO::new).toList();

        return ResponseEntity.ok(vacancyList);

    } 

}