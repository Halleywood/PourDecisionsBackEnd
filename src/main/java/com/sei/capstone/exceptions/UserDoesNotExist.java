package com.sei.capstone.exceptions;

/**
 * custom error messages to gracefully handle exceptions.
 */
public class UserDoesNotExist extends RuntimeException {
    public UserDoesNotExist(String message){
        super(message);
    }
}
