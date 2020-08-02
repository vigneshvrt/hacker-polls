package com.vigneshvrt.hackerpolls.exception;

public enum APIErrorCode {

    //general error code 1 - 1000
    UNKNOWN_ERROR(1),

    //candidate error codes 1001 - 2000
    CANDIDATE_NOT_FOUND(1001),

    //vote error code 2001 - 3000
    ALREADY_VOTED(2001),

    //end
    ;

    int value;
    APIErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
