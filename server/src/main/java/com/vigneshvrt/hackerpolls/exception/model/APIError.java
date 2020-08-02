package com.vigneshvrt.hackerpolls.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIError {
    private int status;
    private int errCode;
    private String errMsg;
    private List<InputError> inputErrors;

    public APIError(int status, int errCode, String errMsg) {
        this.status = status;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
