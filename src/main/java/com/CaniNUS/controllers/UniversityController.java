package com.CaniNUS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CaniNUS.dto.UniversityDTO;
import com.CaniNUS.dto.UniversityResponseDTO;
import com.CaniNUS.models.UniversityModel;
import com.CaniNUS.repositories.UniversityRepository;

import jakarta.validation.Valid;

@SuppressWarnings("rawtypes")
public class UniversityController {
    
    @Autowired
    UniversityRepository ur;

    // CRUD:

    @PostMapping("/university/create")
    public ResponseEntity createNewUniversity(@RequestBody @Valid UniversityDTO data) {

        if (this.ur.findByUniversityName(data.name()) != null) return ResponseEntity.badRequest().build();

        UniversityModel newUniversity = new UniversityModel(data.name());

        this.ur.save(newUniversity);

        return ResponseEntity.ok().build();

    }

    @PostMapping("/university/read")
    public ResponseEntity readAllUniversities() {

        List<UniversityResponseDTO> universityList = this.ur.findAll().stream().map(UniversityResponseDTO::new).toList();

        return ResponseEntity.ok(universityList);

    }

}
