package com.sei.capstone.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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

    /**
     * Only one userProfile to one User.
     */
    @OneToOne(mappedBy = "userProfile")
    private User user;
    public UserProfile() {
    }

    /**
     * a UserProfile can have many posts about the wines they've tried.
     */
    @OneToMany(mappedBy = "userProfile")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Post> userPosts;
    

    public UserProfile( String userName, String tagline) {
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
