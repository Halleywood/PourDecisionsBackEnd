package com.sei.capstone.exceptions;

/**
 * custom error messages to gracefully handle exceptions.
 */
public class UserExistsException extends RuntimeException {
    public UserExistsException(String message){
        super(message);
    }
}
