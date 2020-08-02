package com.vigneshvrt.hackerpolls.exception.handler;


import com.vigneshvrt.hackerpolls.exception.APIErrorCode;
import com.vigneshvrt.hackerpolls.exception.APIException;
import com.vigneshvrt.hackerpolls.exception.model.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIError> handleException(Exception exception) {

        APIError apiError;
        if (exception instanceof APIException) {

            APIException ex = (APIException) exception;
            apiError = new APIError(ex.getStatus().value(),
                    ex.getError().value(),
                    ex.getMessage());
        } else {

            apiError = new APIError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    APIErrorCode.UNKNOWN_ERROR.value(),
                    exception.getMessage());
        }

        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
