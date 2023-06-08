package com.sei.capstone.model.login;

/**
 * sends message back to user after success or unsuccessful login.
 */
public class LoginResponse {

        private String message;

        public LoginResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

}
