package com.sei.capstone.model.login;

public class RegisterDTO {

    private String email;
    private String password;
    private String userName;
    private String tagline;
    private String imgSrc;

    public RegisterDTO() {
    }

    public RegisterDTO(String email, String password, String userName, String tagline, String imgSrc) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.tagline = tagline;
        this.imgSrc = imgSrc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
