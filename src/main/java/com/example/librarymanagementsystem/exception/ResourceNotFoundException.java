// src/main/java/com/example/librarymanagementsystem/exception/ResourceNotFoundException.java
package com.example.librarymanagementsystem.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}