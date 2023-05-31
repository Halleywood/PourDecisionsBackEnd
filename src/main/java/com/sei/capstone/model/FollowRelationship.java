package com.sei.capstone.model;

import javax.persistence.*;

@Entity
@Table(name="follow_relationships")
public class FollowRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Every follow relationship has a FOLLOWER and the userProfile they are FOLLOWING
     */
    @ManyToOne
    @JoinColumn(name = "follower_id")
    private UserProfile follower;

    public UserProfile getFollower() {
        return follower;
    }

    public void setFollower(UserProfile follower) {
        this.follower = follower;
    }

    @ManyToOne
    @JoinColumn(name= "followed_id")
    private UserProfile followed;

    public UserProfile getFollowed() {
        return followed;
    }

    public void setFollowed(UserProfile followed) {
        this.followed = followed;
    }

    /**
     * CONSTRUCTORS
     */
    public FollowRelationship() {
    }

    public FollowRelationship(UserProfile follower, UserProfile followed) {
        this.follower = follower;
        this.followed = followed;
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


    @Override
    public String toString() {
        return "FollowRelationship{" +
                "id=" + id +
                ", follower=" + follower +
                ", followed=" + followed +
                '}';
    }
}
