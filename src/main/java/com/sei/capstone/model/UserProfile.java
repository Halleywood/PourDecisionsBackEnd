package com.sei.capstone.model;

import javax.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(unique = true)
    private String userName;

    @Column
    private String tagline;

    public UserProfile() {
    }

    public UserProfile(Long profileId, String userName, String tagline) {
        this.profileId = profileId;
        this.userName = userName;
        this.tagline = tagline;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
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

    @Override
    public String toString() {
        return "UserProfile{" +
                "profileId=" + profileId +
                ", userName='" + userName + '\'' +
                ", tagline='" + tagline + '\'' +
                '}';
    }
}
