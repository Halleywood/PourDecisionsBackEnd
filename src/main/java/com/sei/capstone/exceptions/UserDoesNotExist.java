package com.sei.capstone.exceptions;

public class UserDoesNotExist extends RuntimeException {
    public UserDoesNotExist(String message){
        super(message);
    }
}
