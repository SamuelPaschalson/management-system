// src/main/java/com/example/librarymanagementsystem/exception/ValidationExceptionResponse.java
package com.example.librarymanagementsystem.exception;

import lombok.Data;

import java.util.List;

@Data
public class ValidationExceptionResponse {
    private List<String> errors;

    public ValidationExceptionResponse(List<String> errors) {
        this.errors = errors;
    }
}