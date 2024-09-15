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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "candidates")
public class CandidatesModel implements Serializable {
    
    // Attributes:

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "course_id")
    private UUID courseId;

    @Column(name = "university_id")
    private UUID universityId;

    public CandidatesModel(UUID courseId, UUID universityId) {
        this.courseId = courseId;
        this.universityId = universityId;
    }

}
