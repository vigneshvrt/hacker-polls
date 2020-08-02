package com.vigneshvrt.hackerpolls.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InputError {
    private String field;
    private String message;
}
