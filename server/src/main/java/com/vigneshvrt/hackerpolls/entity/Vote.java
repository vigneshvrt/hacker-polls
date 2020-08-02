package com.vigneshvrt.hackerpolls.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Getter
@Setter
public class Vote {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String clientIP;

    @ManyToOne
    @JoinColumn(name="candidate_id", nullable = false)
    private Candidate candidate;
}
