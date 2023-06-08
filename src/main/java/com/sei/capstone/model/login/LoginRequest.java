package com.sei.capstone.model.login;

/**
 * no setters, only retrieves existing information from database to confirm match.
 */
public class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
