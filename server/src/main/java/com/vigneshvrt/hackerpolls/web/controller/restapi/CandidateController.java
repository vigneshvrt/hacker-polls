package com.vigneshvrt.hackerpolls.web.controller.restapi;


import com.vigneshvrt.hackerpolls.exception.APIException;
import com.vigneshvrt.hackerpolls.service.CandidateService;
import com.vigneshvrt.hackerpolls.web.dto.CandidateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<CandidateDto>> getCandidates() {
        List<CandidateDto> list = service.getCandidates();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CandidateDto> getCandidateDetails( @PathVariable("id") Long id) throws APIException {
        CandidateDto dto = service.getCandidateDetails(id);
        return ResponseEntity.ok(dto);
    }
}
