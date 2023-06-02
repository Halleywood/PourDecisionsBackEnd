package com.sei.capstone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column
    private String tagline;

    @Column
    private String imgSrc;

    /**
     * Only one userProfile to one User.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    /**
     * a UserProfile can have many posts about the wines they've tried.
     */
    @OneToMany(mappedBy = "userProfile", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Post> userPosts;

    public List<Post> getUserPosts() {
        return userPosts;
    }

    public void setUserPosts(List<Post> userPosts) {
        this.userPosts = userPosts;
    }

    /**
     * A userProfile can follow many userProfiles
     */
    @OneToMany(mappedBy = "followed", cascade = CascadeType.ALL)
    private Set<FollowRelationship> followers = new HashSet<>();

    public Set<FollowRelationship> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<FollowRelationship> followers) {
        this.followers = followers;
    }

    /**
     * A userProfile can be followed by many other userProfiles
     */
    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private Set<FollowRelationship> following = new HashSet<>();

    public Set<FollowRelationship> getFollowing() {
        return following;
    }

    public void setFollowing(Set<FollowRelationship> following) {
        this.following = following;
    }

    /**
     * CONSTRUCTORS
     */
    public UserProfile() {
    }
    public UserProfile( String userName, String tagline, String imgSrc) {
        this.userName = userName;
        this.tagline = tagline;
        this.imgSrc = imgSrc;
    }

    /**
     * GETTERS AND SETTERS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", tagline='" + tagline + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", user=" + user +
                ", userPosts=" + userPosts +
                ", followers=" + followers +
                ", following=" + following +
                '}';
    }
}
