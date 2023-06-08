package com.sei.capstone.exceptions;

/**
 * custom error messages to gracefully handle exceptions.
 */
public class InformationNotFoundException extends RuntimeException {
    public InformationNotFoundException(String message) {
        super(message);
    }
}