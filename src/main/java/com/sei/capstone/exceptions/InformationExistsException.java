package com.sei.capstone.exceptions;

/**
 * custom error messages to gracefully handle exceptions.
 */
public class InformationExistsException extends RuntimeException {
    public InformationExistsException(String message) {
        super(message);
    }
}