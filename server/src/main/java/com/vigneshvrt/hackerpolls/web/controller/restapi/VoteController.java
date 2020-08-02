package com.vigneshvrt.hackerpolls.web.controller.restapi;

import com.vigneshvrt.hackerpolls.exception.APIException;
import com.vigneshvrt.hackerpolls.service.VoteService;
import com.vigneshvrt.hackerpolls.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/vote")
public class VoteController {

    @Autowired
    private WebUtil webUtil;

    @Autowired
    private VoteService service;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity addVote(@RequestBody Map<String, Long> payload) throws APIException {
        Long candidateId = payload.get("candidateId");
        service.addVote(candidateId);
        return null;
    }
}
