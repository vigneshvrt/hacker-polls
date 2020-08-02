package com.vigneshvrt.hackerpolls.web.dto;

import com.vigneshvrt.hackerpolls.entity.Candidate;
import com.vigneshvrt.hackerpolls.entity.CandidateExpertise;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

    private long id;
    private String name;
    private int challengesSolved;
    private double rating;
    private List<ExpertiseDto> expertises;
    private long totalVotes;

    public CandidateDto(Candidate candidate) {
        this.id = candidate.getId();
        this.name = candidate.getName();
        this.challengesSolved = candidate.getChallengesSolved();
        this.rating = candidate.getRating();
        List<CandidateExpertise> candidateExpertises = candidate.getExpertises();
        this.expertises = new ArrayList<>();
        for(CandidateExpertise expertise : candidateExpertises) {
            expertises.add(new ExpertiseDto(expertise.getSkill(), expertise.getRating()));
        }
        this.totalVotes = candidate.getVotes().size();
    }
}
