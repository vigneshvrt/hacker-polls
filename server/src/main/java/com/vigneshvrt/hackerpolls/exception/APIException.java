package com.vigneshvrt.hackerpolls.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIException extends Exception {

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    private APIErrorCode error = APIErrorCode.UNKNOWN_ERROR;
    private String message = "server encountered an internal error";

    public APIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public APIException(String message) {
        this.message = message;
    }
}
