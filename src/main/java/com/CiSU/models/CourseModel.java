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
@Table(name = "courses")
public class CourseModel implements Serializable {
    
    // Attributes:

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "university_id")
    private UUID courseUniversity;

    @Column(name = "university_name")
    private String courseUniversityName;

    @Column(name = "university_city")
    private String courseUniversityCity;    

    @Column(name = "name")
    private String courseName; // ADM, Economy, Engineering, Medicine, Pedagogue ,Psychology , TI; Aceito Sugestões :)
    
    @Column(name = "num_of_places")
    private int courseNumOfPlaces;

    @Column(name = "duration")
    private int courseDuration; // In Hours;

    // Constructors:

    public CourseModel() {}

    public CourseModel(UUID universityId, String name, int numOfPlaces, int duration) {
        this.courseUniversity = universityId;
        this.courseName = name;
        this.courseNumOfPlaces = numOfPlaces;
        this.courseDuration = duration;
    }

}
