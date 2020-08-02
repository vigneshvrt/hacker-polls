package com.vigneshvrt.hackerpolls.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class CandidateExpertise {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="candidate_id", nullable = false)
    private Candidate candidate;

    @Column(nullable = false)
    private String skill;

    @Column(nullable = false)
    private double rating;
}
