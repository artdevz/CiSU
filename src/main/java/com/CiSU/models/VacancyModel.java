package com.CiSU.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vacancies")
public class VacancyModel implements Serializable {
    
    // Attributes:

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "course_id")
    private UUID vacancyCourse;

    @Column(name = "user_id")
    private UUID vacancyUser;

    @Column(name = "vacancy_score")
    private float vacancyScore;

    // Constructors:

    public VacancyModel() {}
    
    public VacancyModel(UUID courseId, UUID userId, float score) {
        this.vacancyCourse = courseId;        
        this.vacancyUser = userId;
        this.vacancyScore = score;
    }

}
