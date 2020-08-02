package com.vigneshvrt.hackerpolls.service;

import com.vigneshvrt.hackerpolls.entity.Candidate;
import com.vigneshvrt.hackerpolls.exception.APIErrorCode;
import com.vigneshvrt.hackerpolls.exception.APIException;
import com.vigneshvrt.hackerpolls.repository.CandidateRepository;
import com.vigneshvrt.hackerpolls.web.dto.CandidateDto;
import com.vigneshvrt.hackerpolls.web.dto.ExpertiseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    private List<CandidateDto> candidates;

    @Autowired
    private CandidateRepository repository;

    public List<CandidateDto> getCandidates() {
        List<Candidate> candidates = repository.findAll();
        List<CandidateDto> response = new ArrayList<>();
        for(Candidate candidate : candidates) {
            CandidateDto dto = new CandidateDto(candidate);
            response.add(dto);
        }
        return response;
    }

    public CandidateDto getCandidateDetails(long id) throws APIException {
        Optional<Candidate> candidate = repository.findById(id);
        return candidate.map(CandidateDto::new)
                .orElseThrow(
                        () -> new APIException(HttpStatus.NOT_FOUND, APIErrorCode.CANDIDATE_NOT_FOUND, "Candidate not found")
                );
    }
}
