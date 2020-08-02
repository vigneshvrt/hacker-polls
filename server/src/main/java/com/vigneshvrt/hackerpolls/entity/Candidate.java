package com.vigneshvrt.hackerpolls.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Candidate {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int challengesSolved;

    @Column(nullable = false)
    private double rating;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateExpertise> expertises;

    @OneToMany(mappedBy = "candidate")
    private List<Vote> votes;
}
