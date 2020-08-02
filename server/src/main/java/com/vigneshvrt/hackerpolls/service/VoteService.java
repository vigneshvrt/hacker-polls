package com.vigneshvrt.hackerpolls.service;

import com.vigneshvrt.hackerpolls.entity.Candidate;
import com.vigneshvrt.hackerpolls.entity.Vote;
import com.vigneshvrt.hackerpolls.exception.APIErrorCode;
import com.vigneshvrt.hackerpolls.exception.APIException;
import com.vigneshvrt.hackerpolls.repository.CandidateRepository;
import com.vigneshvrt.hackerpolls.repository.VoteRepository;
import com.vigneshvrt.hackerpolls.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository repository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private WebUtil webUtil;

    public void addVote(long candidateId) throws APIException {
        String clientIP = webUtil.getClientIP();
        Optional<Candidate> candidate = candidateRepository.findById(candidateId);
        if(candidate.isPresent()) {
            Optional<Vote> optionalVote = repository.findByClientIP(clientIP);
            if(optionalVote.isPresent()) {
                throw new APIException(HttpStatus.BAD_REQUEST, APIErrorCode.ALREADY_VOTED, "You've already voted!");
            }
            Vote vote = new Vote();
            vote.setClientIP(clientIP);
            vote.setCandidate(candidate.get());
            repository.saveAndFlush(vote);
        } else {
            throw new APIException(HttpStatus.BAD_REQUEST, APIErrorCode.CANDIDATE_NOT_FOUND, "Invalid candidate id.");
        }
    }
}
