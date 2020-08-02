package com.vigneshvrt.hackerpolls.repository;

import com.vigneshvrt.hackerpolls.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
