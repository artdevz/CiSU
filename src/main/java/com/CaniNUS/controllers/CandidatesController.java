// package com.CaniNUS.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;

// import com.CaniNUS.dto.candidates.CandidatesDTO;
// import com.CaniNUS.models.CandidatesModel;
// import com.CaniNUS.repositories.CandidatesRepository;

// import jakarta.validation.Valid;

// @SuppressWarnings("rawtypes")
// @Controller
// public class CandidatesController {
    
//     @Autowired
//     CandidatesRepository cr;

//     // CRUD:

//     @PostMapping("/vacancy/create")
//     public ResponseEntity createNewVacancy(@RequestBody @Valid CandidatesDTO data) {
        
//         CandidatesModel candidates = new CandidatesModel(data.courseId(), data.universityId());

//         this.cr.save(candidates);

//         return ResponseEntity.ok().build();
//     }

// }